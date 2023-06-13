package com.christianalbers.rockpaperscissorsbackend.service

import com.christianalbers.rockpaperscissorsbackend.entity.User
import com.christianalbers.rockpaperscissorsbackend.repository.UserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)
    fun getAllUsers(): List<String> {
        return userRepository.findAll().map { it.username }
    }

    fun addNewUser(username: String) {
        if(userRepository.findByUsername(username) != null) {
            logger.error("There already exist a user $username. Registration process aborted.")
            throw IllegalStateException("username is already taken.")
        }

        val newUser = User(username)
        userRepository.save(newUser)
        logger.trace("User $username successfully created.")
    }
}
