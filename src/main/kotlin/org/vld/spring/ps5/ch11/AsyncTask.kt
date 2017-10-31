package org.vld.spring.ps5.ch11

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component("asyncTask")
open class AsyncTask {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(AsyncTask::class.java)
    }

    @Async
    fun simpleAsyncTask() {
        Thread.sleep(1000)
        logger.info("Simple async task finished")
    }

}

fun main(args: Array<String>) {
    val context: ApplicationContext = AnnotationConfigApplicationContext(AsyncTaskConfiguration::class.java)
    val asyncTask: AsyncTask = context.getBean("asyncTask", AsyncTask::class.java)
    asyncTask.simpleAsyncTask()
    asyncTask.simpleAsyncTask()

    Thread.sleep(2000)
}