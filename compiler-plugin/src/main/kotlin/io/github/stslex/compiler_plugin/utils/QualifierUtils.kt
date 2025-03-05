package io.github.stslex.compiler_plugin.utils

import io.github.stslex.compiler_plugin.CompilerQualifier
import org.jetbrains.kotlin.ir.declarations.IrSimpleFunction
import org.jetbrains.kotlin.ir.expressions.IrConstructorCall
import org.jetbrains.kotlin.ir.util.getAnnotation
import org.jetbrains.kotlin.ir.util.hasAnnotation
import org.jetbrains.kotlin.name.FqName

internal object QualifierUtils {

    fun IrSimpleFunction.containsQualifier(): Boolean {
        val qualifiedName = CompilerQualifier::class.qualifiedName ?: return false
        return hasAnnotation(FqName(qualifiedName))
    }

    fun IrSimpleFunction.getQualifier(): IrConstructorCall? {
        val qualifiedName = CompilerQualifier::class.qualifiedName ?: return null
        return getAnnotation(FqName(qualifiedName))
    }

}