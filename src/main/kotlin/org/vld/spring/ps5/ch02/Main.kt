package org.vld.spring.ps5.ch02

import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

interface MessageProvider {
    val message: String
}

interface MessageRenderer {
    val messageProvider: MessageProvider
    fun render(): String
}

class LiteralMessageProvider(override val message: String = "Hello Svitlana") : MessageProvider

class PlainTextMessageRenderer(override val messageProvider: MessageProvider) : MessageRenderer {
    override fun render(): String = messageProvider.message
}

fun main(args: Array<String>) {
    val context: ApplicationContext = ClassPathXmlApplicationContext("config/spring/app-context.xml")
    val messageRenderer: MessageRenderer = context.getBean("plainTextMessageRenderer", MessageRenderer::class.java)
    messageRenderer.render()
}