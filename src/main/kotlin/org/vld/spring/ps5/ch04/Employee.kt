package org.vld.spring.ps5.ch04

import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean
import org.springframework.context.support.ClassPathXmlApplicationContext
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

class Employee : InitializingBean, DisposableBean {

    var postConstructCalled: Boolean = false
    var afterPropertiesSetCalled: Boolean = false
    var initMethodCalled: Boolean = false

    // add <context:annotation-config/> to XML configuration
    @PostConstruct
    fun postConstruct() {
        println("** Employee::@postConstruct()")
        postConstructCalled = true
    }

    // InitializingBean interface implementation
    override fun afterPropertiesSet() {
        println("** InitializingBean::afterPropertiesSet()")
        afterPropertiesSetCalled = true
    }

    // add <bean init-method="init"/> to XML configuration
    fun initMethod() {
        println("** Employee::init-method()")
        initMethodCalled = true
    }

    // add <context:annotation-config/> to XML configuration
    @PreDestroy
    fun preDestroy() {
        println("** Employee::@preDestory()")
    }

    // DisposableBean interface implementation
    override fun destroy() {
        println("** DisposableBean::destroy()")
    }

    // add <bean destroy-method="destroy"/> to XML configuration
    // destroy() is not called by Spring for beans with scope="prototype"
    fun destroyMethod() {
        println("** Employee::destroy-method()")
    }

}

fun main(args: Array<String>) {
    val context = ClassPathXmlApplicationContext("classpath:config/spring/ch04-employee-app-context.xml")
    context.getBean("employee", Employee::class.java)
    //context.close();
    // register shutdown hook with JVM
    context.registerShutdownHook();
}