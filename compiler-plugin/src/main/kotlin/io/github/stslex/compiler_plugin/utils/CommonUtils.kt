package io.github.stslex.compiler_plugin.utils

import org.jetbrains.kotlin.name.CallableId
import org.jetbrains.kotlin.name.ClassId
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name
import kotlin.reflect.KClass

internal object CommonUtils {

    val <T : Any> KClass<T>.classId: ClassId
        get() = ClassId(fqName, name)

    val <T : Any> KClass<T>.callableId: CallableId
        get() = CallableId(fqName, name)


    val <T : Any> KClass<T>.fqName: FqName
        get() = FqName(java.`package`.name)

    val <T : Any> KClass<T>.name: Name
        get() = Name.identifier(java.simpleName)
}