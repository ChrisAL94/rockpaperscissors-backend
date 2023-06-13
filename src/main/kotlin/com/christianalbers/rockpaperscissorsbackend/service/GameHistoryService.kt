package com.christianalbers.rockpaperscissorsbackend.service

import com.christianalbers.rockpaperscissorsbackend.dto.GameHistoryDto
import com.christianalbers.rockpaperscissorsbackend.entity.Game
import com.christianalbers.rockpaperscissorsbackend.enums.GameResult
import com.christianalbers.rockpaperscissorsbackend.repository.GameRepository
import com.christianalbers.rockpaperscissorsbackend.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class GameHistoryService(private val userRepository: UserRepository, private val gameRepository: GameRepository) {

    fun getGameHistoryByUsername(username: String): GameHistoryDto {
        val userGameList: List<Game>? = gameRepository.findByUsername(username)
        return generateUserGameHistory(userGameList, username)
    }


    fun getAllUsersGameHistory(): Array<GameHistoryDto> {
        var userGameHistoryArray = arrayOf<GameHistoryDto>()
        val userList = gameRepository.findAllUsernames()
        userList?.forEach {
            userGameHistoryArray.plus(getGameHistoryByUsername(it))
        }
        return userGameHistoryArray
    }

    private fun generateUserGameHistory(userGameList: List<Game>?, username: String): GameHistoryDto {
        var winCount = 0
        var defeatCount = 0
        var tieCount = 0
        userGameList?.forEach {
            when (it.result) {
                GameResult.WIN -> winCount++
                GameResult.DEFEAT -> defeatCount++
                GameResult.TIE -> tieCount++
            }
        }

        return GameHistoryDto(username, winCount, defeatCount, tieCount)
    }
}