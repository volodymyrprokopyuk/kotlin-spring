package org.vld.spring.ps5.ch04

data class Engine(val model: String)

data class Car(val make: String, val engine: Engine)
