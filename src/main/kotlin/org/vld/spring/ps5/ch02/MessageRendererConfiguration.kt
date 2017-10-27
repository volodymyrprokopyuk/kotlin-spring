package org.vld.spring.ps5.ch02

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class MessageRendererConfiguration {

    @Bean
    open fun literalMessageProvider(): MessageProvider {
        val literalMessageProvider = LiteralMessageProvider()
        literalMessageProvider.message = "Hello Svitlana"
        return literalMessageProvider
    }

    @Bean
    open fun plainTextMessageRenderer(): MessageRenderer {
        val plainTextMessageRenderer = PlainTextMessageRenderer(literalMessageProvider())
        return plainTextMessageRenderer
    }

}
