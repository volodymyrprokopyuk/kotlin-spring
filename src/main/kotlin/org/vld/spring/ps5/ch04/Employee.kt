package org.vld.spring.ps5.ch04

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean
import org.springframework.context.support.ClassPathXmlApplicationContext
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

class Employee : InitializingBean, DisposableBean {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(Employee::class.java)
    }

    var postConstructCalled: Boolean = false
    var afterPropertiesSetCalled: Boolean = false
    var initMethodCalled: Boolean = false

    // add <context:annotation-config/> to XML configuration
    @PostConstruct
    fun postConstruct() {
        logger.info("** Employee::@postConstruct()")
        postConstructCalled = true
    }

    // InitializingBean interface implementation
    override fun afterPropertiesSet() {
        logger.info("** InitializingBean::afterPropertiesSet()")
        afterPropertiesSetCalled = true
    }

    // add <bean init-method="init"/> to XML configuration
    fun initMethod() {
        logger.info("** Employee::init-method()")
        initMethodCalled = true
    }

    // add <context:annotation-config/> to XML configuration
    @PreDestroy
    fun preDestroy() {
        logger.info("** Employee::@preDestory()")
    }

    // DisposableBean interface implementation
    override fun destroy() {
        logger.info("** DisposableBean::destroy()")
    }

    // add <bean destroy-method="destroy"/> to XML configuration
    // destroy() is not called by Spring for beans with scope="prototype"
    fun destroyMethod() {
        logger.info("** Employee::destroy-method()")
    }

}

fun main(args: Array<String>) {
    val context = ClassPathXmlApplicationContext("classpath:config/spring/ch04-employee-app-context.xml")
    context.getBean("employee", Employee::class.java)
    //context.close();
    // register shutdown hook in new thread with JVM
    context.registerShutdownHook();
}