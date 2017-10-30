package org.vld.spring.ps5.ch04

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.Resource

@RunWith(SpringRunner::class)
@ExtendWith(SpringExtension::class)
@ContextConfiguration(locations = arrayOf("classpath:config/spring/ch04-employee-app-context.xml"))
class EmployeeTest {

    @Resource(name = "employee")
    lateinit var employee: Employee

    @Test
    @DisplayName("Given an Employee. When get the Employee with init-method. Then call the init-method on the Employee")
    fun givenEmployee_whenGetEmployeeWithInitMethod_thenCallTheInitMethodOnTheEmployee() {
        // Given & When & Then
        assertThat(employee.initCalled).isTrue()
    }

}