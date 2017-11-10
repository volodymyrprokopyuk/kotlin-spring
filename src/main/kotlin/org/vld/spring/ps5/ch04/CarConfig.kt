package org.vld.spring.ps5.ch04

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(EngineConfig::class)
open class CarConfig {

    @Autowired
    private lateinit var engineConfig: EngineConfig

    @Bean
    open fun car(): Car = Car("BMW", engineConfig.engine())

}
