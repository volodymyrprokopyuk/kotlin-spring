package org.vld.spring.ps5.ch04

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.springframework.test.context.ActiveProfiles
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

@RunWith(SpringRunner::class)
@ExtendWith(SpringExtension::class)
// load all configuration profiles into application context
@ContextConfiguration(classes = arrayOf(ProfileACarConfig::class, ProfileBCarConfig::class))
@ActiveProfiles("ProfileA")
class ProfileACarTest {

    @Resource(name = "car")
    private lateinit var car: Car

    @Test
    @DisplayName("Given a car. When get a car. Then return the right car make and engine model")
    fun givenCar_whenGetCar_thenReturnRightCarMakeAndEngineModel() {
        // Given & When
        val make = car.make
        val model = car.engine.model
        // Then
        val expectedMake = "ProfileA BMW"
        assertThat(make).isEqualTo(expectedMake)
        val expectedModel = "ProfileA V8"
        assertThat(model).isEqualTo(expectedModel)
    }
}

@RunWith(SpringRunner::class)
@ExtendWith(SpringExtension::class)
// load all configuration profiles into application context
@ContextConfiguration(classes = arrayOf(ProfileACarConfig::class, ProfileBCarConfig::class))
@ActiveProfiles("ProfileB")
class ProfileBCarTest {

    @Resource(name = "car")
    private lateinit var car: Car

    @Test
    @DisplayName("Given a car. When get a car. Then return the right car make and engine model")
    fun givenCar_whenGetCar_thenReturnRightCarMakeAndEngineModel() {
        // Given & When
        val make = car.make
        val model = car.engine.model
        // Then
        val expectedMake = "ProfileB BMW"
        assertThat(make).isEqualTo(expectedMake)
        val expectedModel = "ProfileB V8"
        assertThat(model).isEqualTo(expectedModel)
    }
}
