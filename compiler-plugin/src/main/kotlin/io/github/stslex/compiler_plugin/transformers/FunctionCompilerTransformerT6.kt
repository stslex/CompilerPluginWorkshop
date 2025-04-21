package io.github.stslex.compiler_plugin.transformers

import io.github.stslex.compiler_plugin.task_configure.TransformerDeps
import org.jetbrains.kotlin.backend.common.IrElementTransformerVoidWithContext
import org.jetbrains.kotlin.ir.IrStatement
import org.jetbrains.kotlin.ir.declarations.IrSimpleFunction

internal class FunctionCompilerTransformerT6(
    private val dependencies: TransformerDeps.Dependencies
) : IrElementTransformerVoidWithContext() {

    override fun visitSimpleFunction(declaration: IrSimpleFunction): IrStatement {
        return super.visitSimpleFunction(declaration)
    }

}
