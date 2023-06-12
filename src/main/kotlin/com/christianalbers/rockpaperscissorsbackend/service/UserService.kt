package com.christianalbers.rockpaperscissorsbackend.service

import com.christianalbers.rockpaperscissorsbackend.entity.User
import com.christianalbers.rockpaperscissorsbackend.repository.userRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService(private val userRepository: userRepository) {

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun addNewUser(username: String) {
        if(userRepository.findByUsername(username) != null) {
            throw IllegalStateException("username is already taken.")
        }

        val newUser = User(username)
        userRepository.save(newUser)
    }
}