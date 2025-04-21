package io.github.stslex.compiler_plugin

import io.github.stslex.compiler_plugin.task_configure.TransformerDeps.DependenciesBuilder.Companion.dependenciesBuilder
import io.github.stslex.compiler_plugin.task_configure.TransformerDeps.ExDependencies
import io.github.stslex.compiler_plugin.task_configure.TransformerTask
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment
import org.jetbrains.kotlin.ir.visitors.transformChildrenVoid

internal class WorkshopCompilerExtension(
    private val configuration: CompilerConfiguration,
    private val exDependencies: ExDependencies? = null,
    private val task: TransformerTask = TransformerTask.Task1
) : IrGenerationExtension {

    override fun generate(
        moduleFragment: IrModuleFragment,
        pluginContext: IrPluginContext,
    ) {
        moduleFragment.transformChildrenVoid(
            transformer = task.build(
                exDependencies = exDependencies,
                builder = configuration.dependenciesBuilder(pluginContext),
            )
        )
    }
}
