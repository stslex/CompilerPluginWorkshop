package io.github.stslex.compiler_plugin.task_configure

import io.github.stslex.compiler_plugin.task_configure.TransformerDeps.Dependencies
import io.github.stslex.compiler_plugin.task_configure.TransformerDeps.DependenciesBuilder
import io.github.stslex.compiler_plugin.task_configure.TransformerDeps.ExDependencies
import io.github.stslex.compiler_plugin.transformers.FunctionCompilerTransformerT1
import io.github.stslex.compiler_plugin.transformers.FunctionCompilerTransformerT2
import io.github.stslex.compiler_plugin.transformers.FunctionCompilerTransformerT3
import io.github.stslex.compiler_plugin.transformers.FunctionCompilerTransformerT4
import io.github.stslex.compiler_plugin.transformers.FunctionCompilerTransformerT5
import io.github.stslex.compiler_plugin.transformers.FunctionCompilerTransformerT6
import org.jetbrains.kotlin.backend.common.IrElementTransformerVoidWithContext

internal sealed class TransformerTask(
    private val builder: (Dependencies) -> IrElementTransformerVoidWithContext
) {

    data object Task1 : TransformerTask(::FunctionCompilerTransformerT1)

    data object Task2 : TransformerTask(::FunctionCompilerTransformerT2)

    data object Task3 : TransformerTask(::FunctionCompilerTransformerT3)

    data object Task4 : TransformerTask(::FunctionCompilerTransformerT4)

    data object Task5 : TransformerTask(::FunctionCompilerTransformerT5)

    data object Task6 : TransformerTask(::FunctionCompilerTransformerT6)

    fun build(
        builder: DependenciesBuilder,
        exDependencies: ExDependencies?
    ) = builder(mapDeps(exDependencies, builder))
}
