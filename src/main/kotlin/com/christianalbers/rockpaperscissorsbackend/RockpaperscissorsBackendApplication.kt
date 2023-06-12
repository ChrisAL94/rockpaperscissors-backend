package com.christianalbers.rockpaperscissorsbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class RockpaperscissorsBackendApplication

fun main(args: Array<String>) {
    runApplication<RockpaperscissorsBackendApplication>(*args)
}
