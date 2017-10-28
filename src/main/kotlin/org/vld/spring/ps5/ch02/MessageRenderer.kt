package org.vld.spring.ps5.ch02

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext // ktlint-disable no-unused-imports

interface MessageProvider {
    val message: String
}

interface MessageRenderer {
    val messageProvider: MessageProvider
    fun render(): String
}

class LiteralMessageProvider : MessageProvider {
    override lateinit var message: String
}

class PlainTextMessageRenderer(override val messageProvider: MessageProvider) : MessageRenderer {
    override fun render(): String = messageProvider.message
}

fun main(args: Array<String>) {
    //val context: ApplicationContext
    //        = ClassPathXmlApplicationContext("config/spring/ch02-message-renderer-app-context.xml")
    val context: ApplicationContext = AnnotationConfigApplicationContext(MessageRendererConfiguration::class.java)
    // Inversion of Control (IoC) > Dependency Lookup > Dependency Pull
    val messageRenderer: MessageRenderer = context.getBean("plainTextMessageRenderer", MessageRenderer::class.java)
    messageRenderer.render()
}
