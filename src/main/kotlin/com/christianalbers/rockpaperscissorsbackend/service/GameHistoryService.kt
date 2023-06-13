package com.christianalbers.rockpaperscissorsbackend.service

import com.christianalbers.rockpaperscissorsbackend.dto.GameHistoryDto
import com.christianalbers.rockpaperscissorsbackend.entity.Game
import com.christianalbers.rockpaperscissorsbackend.enums.GameResult
import com.christianalbers.rockpaperscissorsbackend.repository.GameRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class GameHistoryService(private val gameRepository: GameRepository) {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    fun getGameHistoryByUsername(username: String): GameHistoryDto {
        val userGameList: List<Game>? = gameRepository.findByUsername(username)
        return generateUserGameHistory(userGameList, username)
    }


    fun getAllUsersGameHistory(): Array<GameHistoryDto> {
        var userGameHistoryArray = arrayOf<GameHistoryDto>()
        val userList = gameRepository.findAllUsernames()
        if (userList != null) {
            logger.warn("No user history persisted yet.")
        }
        userList?.forEach {
            val gameHistoryByUserName = getGameHistoryByUsername(it)
            userGameHistoryArray = userGameHistoryArray.plus(gameHistoryByUserName)
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