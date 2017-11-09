package org.vld.spring.ps5.ch02

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class MessageRendererConfig {

    @Bean
    // method name is bean id or name
    // prefer constructor injection to produce immutable objects
    open fun literalMessageProvider(): MessageProvider = LiteralMessageProvider("Hello Svitlana")

    @Bean
    // method name is bean id or name
    // prefer constructor injection to produce immutable objects
    open fun plainTextMessageRenderer(): MessageRenderer = PlainTextMessageRenderer(literalMessageProvider())

}
