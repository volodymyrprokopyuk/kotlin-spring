package org.vld.spring.ps5.ch03

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext // ktlint-disable no-unused-imports
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

interface MessageProvider {
    val message: String
}

interface MessageRenderer {
    val messageProvider: MessageProvider
    fun render(): String
}

@Component("literalMessageProvider")
class LiteralMessageProvider : MessageProvider {
    @Value("Hello Svitlana")
    override lateinit var message: String
}

@Service("plainTextMessageRenderer")
class PlainTextMessageRenderer(
        @Autowired @Qualifier("literalMessageProvider") override val messageProvider: MessageProvider
) : MessageRenderer {
    override fun render(): String = messageProvider.message
}

fun main(args: Array<String>) {
    //val context: ApplicationContext
    //        = ClassPathXmlApplicationContext("config/spring/ch03-message-renderer-app-context.xml")
    val context: ApplicationContext = AnnotationConfigApplicationContext(MessageRendererConfiguration::class.java)
    // Inversion of Control (IoC) > Dependency Lookup > Dependency Pull
    val messageRenderer: MessageRenderer = context.getBean("plainTextMessageRenderer", MessageRenderer::class.java)
    messageRenderer.render()
}
