package org.vld.spring.ps5.ch04

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

class Employee : InitializingBean, DisposableBean {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(Employee::class.java)
    }

    @PostConstruct
    fun postConstruct() {
        logger.info("** Employee::@PostConstruct()")
    }

    // InitializingBean interface implementation
    override fun afterPropertiesSet() {
        logger.info("** InitializingBean::afterPropertiesSet()")
    }

    // @Bean(initMethod = "initMethod")
    fun initMethod() {
        logger.info("** Employee::@Bean(initMethod)")
    }

    @PreDestroy
    fun preDestroy() {
        logger.info("** Employee::@PreDestory()")
    }

    // DisposableBean interface implementation
    override fun destroy() {
        logger.info("** DisposableBean::destroy()")
    }

    // @Bean(destroyMethod = "destroyMethod")
    // destroy() is not called by Spring for beans with scope="prototype"
    fun destroyMethod() {
        logger.info("** Employee::@Bean(destroyMethod)")
    }
}

fun main(args: Array<String>) {
    val context = AnnotationConfigApplicationContext(EmployeeConfig::class.java)
    context.getBean("employee", Employee::class.java)
    //context.close()
    // register shutdown hook in new thread with JVM
    context.registerShutdownHook()
}
