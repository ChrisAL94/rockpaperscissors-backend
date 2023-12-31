package com.christianalbers.rockpaperscissorsbackend.config

import com.christianalbers.rockpaperscissorsbackend.entity.User
import com.christianalbers.rockpaperscissorsbackend.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime

@Configuration
class UserConfig {

    val testUser1 = User("testUser1", LocalDateTime.now())
    val testUser2 = User("testUser2", LocalDateTime.now())
    val testUser3 = User("testUser3", LocalDateTime.now())
    val testUser4 = User("testUser4", LocalDateTime.now())
    val testUser5 = User("testUser5", LocalDateTime.now())


    @Bean
    fun commandLineRunnerUser(repository: UserRepository): CommandLineRunner {
        return CommandLineRunner {
            repository.saveAll(listOf(testUser1, testUser2, testUser3, testUser4, testUser5))
        }
    }
}