package org.vld.spring.ps5.ch02

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource("classpath:config/ch02-application.properties")
open class MessageRendererConfig {

    @Value("\${ps5.ch02.messageProvider.literal.message}")
    private lateinit var message: String

    @Bean
    // method name is bean id or name
    // prefer constructor injection to produce immutable objects
    open fun literalMessageProvider(): MessageProvider = LiteralMessageProvider(message)

    @Bean
    // method name is bean id or name
    // prefer constructor injection to produce immutable objects
    open fun plainTextMessageRenderer(): MessageRenderer = PlainTextMessageRenderer(literalMessageProvider())

}
