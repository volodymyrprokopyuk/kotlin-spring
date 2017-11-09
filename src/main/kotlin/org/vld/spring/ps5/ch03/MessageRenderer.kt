package org.vld.spring.ps5.ch03

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

interface MessageProvider {
    val message: String
}

interface MessageRenderer {
    fun render(): String
}

@Component("literalMessageProvider")
class LiteralMessageProvider(@Value("Hello Svitlana") override val message: String) : MessageProvider

@Service("plainTextMessageRenderer")
class PlainTextMessageRenderer(
        @Autowired @Qualifier("literalMessageProvider") private val messageProvider: MessageProvider
) : MessageRenderer {
    override fun render(): String = messageProvider.message
}

fun main(args: Array<String>) {
    val context: ApplicationContext = AnnotationConfigApplicationContext(MessageRendererConfig::class.java)
    // Inversion of Control (IoC) > Dependency Lookup > Dependency Pull (from IoC container)
    val messageRenderer: MessageRenderer = context.getBean("plainTextMessageRenderer", MessageRenderer::class.java)
    messageRenderer.render()
}
