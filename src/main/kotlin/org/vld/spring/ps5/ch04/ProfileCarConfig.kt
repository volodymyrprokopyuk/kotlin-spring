package org.vld.spring.ps5.ch04

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.context.annotation.PropertySource

@Configuration
@Profile("ProfileA")
@PropertySource("classpath:config/ch04-profileA-application.properties")
open class ProfileACarConfig {

    @Value("\${ps5.ch04.engine.model}")
    private lateinit var model: String

    @Value("\${ps5.ch04.car.make}")
    private lateinit var make: String

    @Bean
    open fun engine(): Engine = Engine(model)

    @Bean
    open fun car(): Car = Car(make, engine())

}

@Configuration
@Profile("ProfileB")
@PropertySource("classpath:config/ch04-profileB-application.properties")
open class ProfileBCarConfig {

    @Value("\${ps5.ch04.engine.model}")
    private lateinit var model: String

    @Value("\${ps5.ch04.car.make}")
    private lateinit var make: String

    @Bean
    open fun engine(): Engine = Engine(model)

    @Bean
    open fun car(): Car = Car(make, engine())

}
