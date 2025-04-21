package io.github.stslex.compiler_plugin

import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
public annotation class CompilerQualifier(
    val logging: Boolean = false,
    val action: KClass<*> = Unit::class,
    val name: String = ""
)