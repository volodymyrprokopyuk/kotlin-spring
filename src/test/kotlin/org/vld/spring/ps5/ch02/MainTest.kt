package org.vld.spring.ps5.ch02

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration

@RunWith(JUnitPlatform::class)
@ContextConfiguration(locations = arrayOf("classpath:config/spring/app-context.xml"))
class MainTest {

    @Test
    @DisplayName("given when then")
    fun given_when_then() {
        assertThat(1).isEqualTo(1)
    }

}