package com.christianalbers.rockpaperscissorsbackend.service

import com.christianalbers.rockpaperscissorsbackend.dto.GameHistoryDto
import com.christianalbers.rockpaperscissorsbackend.entity.Game
import com.christianalbers.rockpaperscissorsbackend.entity.User
import com.christianalbers.rockpaperscissorsbackend.enums.GameResult
import com.christianalbers.rockpaperscissorsbackend.repository.GameRepository
import com.christianalbers.rockpaperscissorsbackend.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository, private val gameRepository: GameRepository) {

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

    fun getGameHistoryByUsername(username: String): GameHistoryDto {
        var winCount = 0
        var defeatCount = 0
        var tieCount = 0
        val gameList: List<Game>? = gameRepository.findByUsername(username)
        gameList?.forEach {
            when (it.result) {
                GameResult.WIN -> winCount++
                GameResult.DEFEAT -> defeatCount++
                GameResult.TIE -> tieCount++
            }
        }

        return GameHistoryDto(username, winCount, defeatCount, tieCount)
    }
}