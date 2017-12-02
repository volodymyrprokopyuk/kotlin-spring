package org.vld.spring.ps5.ch11

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.scheduling.annotation.Scheduled

class ScheduledTask {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(ScheduledTask::class.java)
    }

    @Scheduled(fixedDelay = 1000)
    fun scheduledTask() {
        logger.info("** Scheduled Task started")
    }
}

fun main(args: Array<String>) {
    val context: AnnotationConfigApplicationContext =
            AnnotationConfigApplicationContext(ScheduledTaskConfig::class.java)
    Thread.sleep(2100)
    context.close()
}
