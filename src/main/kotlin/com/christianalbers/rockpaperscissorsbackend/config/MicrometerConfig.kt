package com.christianalbers.rockpaperscissorsbackend.config

import io.micrometer.core.instrument.simple.SimpleMeterRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MicrometerConfig {

    @Bean
    fun getMeterRegistry(): SimpleMeterRegistry {
        return SimpleMeterRegistry()
    }
}