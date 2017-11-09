package org.vld.spring.ps5.ch03

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringRunner
import java.util.Properties

@RunWith(SpringRunner::class)
@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = arrayOf(EmployeeConfiguration::class))
class EmployeeTest {

    @Autowired
    @Qualifier("employee")
    private lateinit var employee: Employee

    @Test
    @DisplayName("Given an employee. When create the employee. Then the employee is properly configured")
    fun givenEmployee_whenCreateEmployee_thenReturnProperlyConfiguredEmployee() {
        // Given & When
        val firstName = employee.firstName
        val fullName = employee.fullName
        val responsibilities = employee.responsibilities
        val competencies = employee.competencies
        val education = employee.education
        val contact = employee.contact
        // Then
        val expectedFirstName = "Volodymyr"
        assertThat(firstName).isEqualTo(expectedFirstName)
        val expectedFullName = "Volodymyr Prokopyuk"
        assertThat(fullName).isEqualTo(expectedFullName)
        val expectedResponsibilities = listOf(
                "Requirements Elicitation",
                "Software Design",
                "Software Development",
                "Software Testing",
                "Software Deployment"
        )
        assertThat(responsibilities).isEqualTo(expectedResponsibilities)
        val expectedCompetencies = setOf("Kotlin", "Spring", "Git")
        assertThat(expectedCompetencies).isEqualTo(competencies)
        val expectedEducation = mapOf(
                "MBA" to "Master in Business Administration",
                "MSc" to "Master of Science",
                "BSc" to "Bachelor of Science"
        )
        assertThat(education).isEqualTo(expectedEducation)
        val expectedContact = Properties()
        expectedContact.setProperty("org.vld.spring.email", "volodymyrprokopyuk@gmail.com")
        expectedContact.setProperty("org.vld.spring.phone", "123456789")
        assertThat(contact).isEqualTo(expectedContact)
    }

}
