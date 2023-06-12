package com.christianalbers.rockpaperscissorsbackend.config

import com.christianalbers.rockpaperscissorsbackend.entity.User
import com.christianalbers.rockpaperscissorsbackend.repository.userRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate
import java.time.LocalDateTime

@Configuration
class UserConfig {

    @Bean
    fun commandLineRunner(repository: userRepository): CommandLineRunner {
        return CommandLineRunner { args ->
            User("testUser1", LocalDateTime.now())
        }
    }
}