package io.github.stslex.compiler_plugin.transformers

import io.github.stslex.compiler_plugin.utils.CompilerLogger
import org.jetbrains.kotlin.backend.common.IrElementTransformerVoidWithContext
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.ir.IrStatement
import org.jetbrains.kotlin.ir.declarations.IrSimpleFunction

internal class FunctionCompilerTransformer(
    private val pluginContext: IrPluginContext,
    private val logger: CompilerLogger
) : IrElementTransformerVoidWithContext() {

    override fun visitSimpleFunction(declaration: IrSimpleFunction): IrStatement {
        return super.visitSimpleFunction(declaration)
    }
}
