package io.github.stslex.compiler_plugin.utils

import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector

internal class CompilerLogger(
    private val messageCollector: MessageCollector
) {

    fun i(msg: String) {
        messageCollector.report(CompilerMessageSeverity.INFO, msg)
    }
}