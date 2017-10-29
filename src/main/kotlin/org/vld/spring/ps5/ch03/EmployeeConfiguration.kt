package org.vld.spring.ps5.ch03

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource

@Configuration
@ImportResource(locations = arrayOf("classpath:config/spring/ch03-employee-app-context.xml"))
open class EmployeeConfiguration
