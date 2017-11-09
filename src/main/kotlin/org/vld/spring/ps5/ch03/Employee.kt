package org.vld.spring.ps5.ch03

import java.util.Properties

data class Employee(
    val firstName: String,
    val lastName: String,
    val responsibilities: List<String>,
    val competencies: Set<String>,
    val education: Map<String, String>,
    val contact: Properties
)
