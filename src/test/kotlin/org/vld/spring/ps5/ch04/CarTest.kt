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
@ContextConfiguration(classes = arrayOf(CarConfig::class))
class CarTest {

    @Resource(name = "car")
    private lateinit var car: Car

    @Test
    @DisplayName("Given a car. When get a car. Then return the right car make and engine model")
    fun givenCar_whenGetCar_thenReturnRightCarMakeAndEngineModel() {
        // Given & When
        val make = car.make
        val model = car.engine.model
        // Then
        val expectedMake = "BMW"
        assertThat(make).isEqualTo(expectedMake)
        val expectedModel = "V8"
        assertThat(model).isEqualTo(expectedModel)
    }

}