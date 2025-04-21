package io.github.stslex.compiler_plugin.task_configure

import io.github.stslex.compiler_plugin.task_configure.TransformerDeps.Dependencies
import io.github.stslex.compiler_plugin.task_configure.TransformerDeps.DependenciesBuilder
import io.github.stslex.compiler_plugin.task_configure.TransformerDeps.ExDependencies
import io.github.stslex.compiler_plugin.utils.CompilerLogger
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.cli.common.CLIConfigurationKeys
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.config.CompilerConfiguration

internal interface TransformerDeps {

    val pluginContext: IrPluginContext?
    val logger: CompilerLogger?

    data class Dependencies(
        override val pluginContext: IrPluginContext,
        override val logger: CompilerLogger
    ) : TransformerDeps

    data class ExDependencies(
        override val logger: CompilerLogger?
    ) : TransformerDeps {

        override val pluginContext: IrPluginContext? = null
    }

    data class DependenciesBuilder(
        val pluginContext: () -> IrPluginContext,
        val logger: () -> CompilerLogger
    ) {

        companion object {

            fun CompilerConfiguration.dependenciesBuilder(
                pluginContext: IrPluginContext
            ) = DependenciesBuilder(
                pluginContext = { pluginContext },
                logger = {
                    CompilerLogger(
                        messageCollector = get(
                            CLIConfigurationKeys.MESSAGE_COLLECTOR_KEY,
                            MessageCollector.NONE
                        )
                    )
                }
            )
        }
    }
}

internal fun mapDeps(
    exDependencies: ExDependencies?,
    dependenciesBuilder: DependenciesBuilder
): Dependencies = Dependencies(
    pluginContext = exDependencies?.pluginContext ?: dependenciesBuilder.pluginContext(),
    logger = exDependencies?.logger ?: dependenciesBuilder.logger()
)