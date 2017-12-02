package org.vld.spring.ps5.ch03

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import java.util.Properties

@Configuration
@ComponentScan(basePackages = ["org.vld.spring.ps5.ch03"])
open class EmployeeConfig {

    @Bean
    open fun responsibilities(): List<String> = listOf(
            "Requirements Elicitation",
            "Software Design",
            "Software Development",
            "Software Testing",
            "Software Deployment"
    )

    @Bean
    open fun competencies(): Set<String> = setOf("Kotlin", "Spring", "Git")

    @Bean
    open fun education(): Map<String, String> = mapOf(
            "MBA" to "Master in Business Administration",
            "MSc" to "Master of Science",
            "BSc" to "Bachelor of Science"
    )

    @Bean
    open fun contact(): Properties {
        val contact = Properties()
        contact.setProperty("org.vld.spring.email", "volodymyrprokopyuk@gmail.com")
        contact.setProperty("org.vld.spring.phone", "123456789")
        return contact
    }

    @Bean
    open fun employee(): Employee = Employee(
            firstName = "Volodymyr",
            lastName = "Prokopyuk",
            responsibilities = responsibilities(),
            competencies = competencies(),
            education = education(),
            contact = contact()
    )
}
