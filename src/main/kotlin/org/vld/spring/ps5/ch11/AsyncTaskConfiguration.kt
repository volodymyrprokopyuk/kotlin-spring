package org.vld.spring.ps5.ch11

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync

@Configuration
@ComponentScan(basePackages = arrayOf("org.vld.spring.ps5.ch11"))
@EnableAsync
open class AsyncTaskConfiguration