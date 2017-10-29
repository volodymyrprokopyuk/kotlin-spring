package org.vld.spring.ps5.ch03

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.Properties
import javax.annotation.Resource

@Component("employee")
class Employee {

    @Value("Volodymyr")
    lateinit var firstName: String

    @Value("Prokopyuk")
    lateinit var lastName: String

    // Spring Expression Language (SpEL) uses #{...}
    @Value("#{employee.firstName + ' ' + employee.lastName}")
    lateinit var fullName: String

    // @Resource references a dependency by bean id
    @Resource(name = "responsibilities")
    lateinit var responsibilities: List<String>

    @Resource(name = "competencies")
    lateinit var competencies: Set<String>

    @Resource(name = "education")
    lateinit var education: Map<String, String>

    @Resource(name = "contact")
    lateinit var contact: Properties

}
