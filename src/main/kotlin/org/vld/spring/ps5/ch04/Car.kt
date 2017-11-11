package org.vld.spring.ps5.ch04

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

data class Engine(val model: String)

data class Car(val make: String, val engine: Engine)

// run with -Dspring.profiles.active=ProfileA JVM option
fun main(args: Array<String>) {
    val logger: Logger = LoggerFactory.getLogger("org.vld.spring.ps5.ch04.MainKt")
    // load all configuration profiles into application context
    val context: ApplicationContext = AnnotationConfigApplicationContext(
            ProfileACarConfig::class.java, ProfileBCarConfig::class.java
    )
    val car: Car = context.getBean("car", Car::class.java)
    logger.info("${car.make} with ${car.engine.model}")
}
