package org.vld.spring.ps5.ch02

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

interface MessageProvider {
    val message: String
}

interface MessageRenderer {
    fun render(): String
}

// prefer constructor injection, after construction the object is in valid state
class LiteralMessageProvider(override val message: String) : MessageProvider

// prefer constructor injection, after construction the object is in valid state
class PlainTextMessageRenderer(private val messageProvider: MessageProvider) : MessageRenderer {
    override fun render(): String = messageProvider.message
}

fun main(args: Array<String>) {
    val context: ApplicationContext = AnnotationConfigApplicationContext(MessageRendererConfig::class.java)
    // Inversion of Control (IoC) > Dependency Lookup > Dependency Pull (by IoC container)
    val messageRenderer: MessageRenderer = context.getBean("plainTextMessageRenderer", MessageRenderer::class.java)
    messageRenderer.render()
}
