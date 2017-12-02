package org.vld.spring.ps5.ch04

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class EmployeeConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    open fun employee() = Employee()
}
