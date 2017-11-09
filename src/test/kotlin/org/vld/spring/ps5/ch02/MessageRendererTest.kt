package org.vld.spring.ps5.ch02

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = arrayOf(MessageRendererConfiguration::class))
class MessageRendererTest {

    @Autowired
    @Qualifier("plainTextMessageRenderer")
    private lateinit var messageRenderer: MessageRenderer

    @Test
    @DisplayName("Given a PainTextMessageRenderer. When render a message. Then the right message is rendered")
    fun givenPlainTextMessageRenderer_whenRenderMessage_thenTheRightMessageIsRendered() {
        // Given & When
        val message = messageRenderer.render()
        // Then
        val expectedMessage = "Hello Svitlana"
        assertThat(message).isEqualTo(expectedMessage)
    }

}
