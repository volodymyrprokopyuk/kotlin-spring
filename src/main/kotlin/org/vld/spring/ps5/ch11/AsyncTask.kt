package org.vld.spring.ps5.ch11

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.core.task.TaskExecutor
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.AsyncResult
import java.util.concurrent.Future

open class AsyncTask {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(AsyncTask::class.java)
    }

    @Async
    fun simpleAsyncTask() {
        Thread.sleep(1000)
        logger.info("Simple async task finished")
    }

    @Async
    fun asyncTaskWithParametersAndReturnValue(task: String): Future<String> {
        Thread.sleep(1000)
        return AsyncResult<String>("$task finished")
    }

}

class AsyncTaskExecutor(private val taskExecutor: TaskExecutor) {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(AsyncTaskExecutor::class.java)
    }

    fun executeAsyncTasks() {
        for (task in 1..2) taskExecutor.execute { logger.info("Task $task finished") }
    }

}

fun main(args: Array<String>) {
    val logger: Logger = LoggerFactory.getLogger("org.vld.spring.ps5.ch11.MainKt")
    val context: ApplicationContext = AnnotationConfigApplicationContext(AsyncTaskConfig::class.java)
    val asyncTask: AsyncTask = context.getBean("asyncTask", AsyncTask::class.java)
    // start simple async tasks
    asyncTask.simpleAsyncTask()
    asyncTask.simpleAsyncTask()
    // start async tasks and store Future result
    val asyncResult1 = asyncTask.asyncTaskWithParametersAndReturnValue("Task 1")
    val asyncResult2 = asyncTask.asyncTaskWithParametersAndReturnValue("Task 2")
    // wait for all async tasks to complete
    Thread.sleep(1100)
    // retrieve Future result
    logger.info(asyncResult1.get())
    logger.info(asyncResult2.get())
    // execute async tasks using TaskExecutor
    val asyncTaskExecutor: AsyncTaskExecutor = context.getBean("asyncTaskExecutor", AsyncTaskExecutor::class.java)
    asyncTaskExecutor.executeAsyncTasks()
    Thread.sleep(500)
}
