package com.christianalbers.rockpaperscissorsbackend.service

import com.christianalbers.rockpaperscissorsbackend.dto.GameHistoryDto
import com.christianalbers.rockpaperscissorsbackend.entity.Game
import com.christianalbers.rockpaperscissorsbackend.entity.User
import com.christianalbers.rockpaperscissorsbackend.enums.GameResult
import com.christianalbers.rockpaperscissorsbackend.repository.GameRepository
import com.christianalbers.rockpaperscissorsbackend.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<String> {
        return userRepository.findAll().map { it.username }
    }

    fun addNewUser(username: String) {
        if(userRepository.findByUsername(username) != null) {
            throw IllegalStateException("username is already taken.")
        }

        val newUser = User(username)
        userRepository.save(newUser)
    }
}
