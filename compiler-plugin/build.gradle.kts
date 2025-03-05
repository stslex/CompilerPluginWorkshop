plugins {
    `java-library`
    `maven-publish`
    signing
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

dependencies {
    implementation(kotlin("stdlib"))
    compileOnly(libs.jetbrains.kotlin.compiler.embeddable)
}
