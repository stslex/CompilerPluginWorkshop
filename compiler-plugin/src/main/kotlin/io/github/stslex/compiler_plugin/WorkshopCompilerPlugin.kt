package io.github.stslex.compiler_plugin

import io.github.stslex.compiler_plugin.task_configure.TransformerDeps.ExDependencies
import io.github.stslex.compiler_plugin.task_configure.TransformerTask
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.compiler.plugin.CompilerPluginRegistrar
import org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi
import org.jetbrains.kotlin.config.CompilerConfiguration

@OptIn(ExperimentalCompilerApi::class)
internal class WorkshopCompilerPlugin(
    override val supportsK2: Boolean = true,
    private val exDependencies: ExDependencies? = null,
    private val task: TransformerTask = TransformerTask.Task2
) : CompilerPluginRegistrar() {

    override fun ExtensionStorage.registerExtensions(configuration: CompilerConfiguration) {
        IrGenerationExtension.registerExtension(
            WorkshopCompilerExtension(
                configuration = configuration,
                exDependencies = exDependencies,
                task = task
            )
        )
    }
}