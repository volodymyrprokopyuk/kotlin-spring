package org.vld.spring.ps5.ch04

import org.springframework.beans.factory.InitializingBean
import javax.annotation.PostConstruct

class Employee : InitializingBean {

    var initCalled: Boolean = false
    var afterPropertiesSetCalled: Boolean = false
    var postConstructCalled: Boolean = false

    // <bean init-method="init"/>
    fun init() {
        initCalled = true
    }

    // InitializingBean interface implementation
    override fun afterPropertiesSet() {
        afterPropertiesSetCalled = true
    }

    // <context:annotation-config/>
    @PostConstruct
    fun postConstruct() {
        postConstructCalled = true
    }

}