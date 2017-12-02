package org.vld.spring.ps5.ch11

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling

@Configuration
@EnableScheduling
open class ScheduledTaskConfig {

    @Bean
    open fun scheduledTask(): ScheduledTask = ScheduledTask()
}
