plugins {
    `java-library`
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

kotlin {
    explicitApi()
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21
    }
}

dependencies {
    implementation(kotlin("stdlib"))

    compileOnly(libs.jetbrains.kotlin.compiler.embeddable)

    testImplementation(platform("org.junit:junit-bom:5.9.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.platform:junit-platform-launcher:1.10.2")
    testImplementation("io.mockk:mockk:1.13.17")

    testImplementation("com.github.tschuchortdev:kotlin-compile-testing:1.6.0")
    testImplementation(libs.jetbrains.kotlin.compiler.embeddable)
    testImplementation("org.ow2.asm:asm:9.2")
    testImplementation("org.assertj:assertj-core:3.27.3")
}

tasks.register<Jar>("mainPluginJar") {
    archiveClassifier.set("plugin")
    from(sourceSets["main"].output)
}

tasks.register<JavaExec>("runTestWithPlugin") {
    dependsOn("mainPluginJar")
    classpath = files(
        "$buildDir/libs/compiler-plugin-test.jar",
        "$buildDir/libs/compiler-plugin-plugin.jar"
    )
    mainClass.set("io.github.stslex.compiler_plugin.TestRunner")
}

tasks.register<Jar>("javadocJar") {
    archiveClassifier.set("javadoc")
}

tasks.register<Jar>("sourcesJar") {
    archiveClassifier.set("sources")
    from(sourceSets["main"].allSource)
}

tasks.test {
    useJUnitPlatform()
}
