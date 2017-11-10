package org.vld.spring.ps5.ch04

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("ProfileA")
open class ProfileACarConfig {

    @Bean
    open fun engine(): Engine = Engine("ProfileA V8")

    @Bean
    open fun car(): Car = Car("ProfileA BMW", engine())

}

@Configuration
@Profile("ProfileB")
open class ProfileBCarConfig {

    @Bean
    open fun engine(): Engine = Engine("ProfileB V8")

    @Bean
    open fun car(): Car = Car("ProfileB BMW", engine())

}
