package org.vld.spring.ps5.ch11

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.core.task.SimpleAsyncTaskExecutor
import org.springframework.core.task.TaskExecutor
import org.springframework.scheduling.annotation.EnableAsync

@Configuration
@ComponentScan(basePackages = arrayOf("org.vld.spring.ps5.ch11"))
@EnableAsync
open class AsyncTaskConfiguration {

    // creates new thread on each invocation, does not reuse existing threads
    @Bean
    open fun simpleAsyncTaskExecutor(): TaskExecutor = SimpleAsyncTaskExecutor()

}
