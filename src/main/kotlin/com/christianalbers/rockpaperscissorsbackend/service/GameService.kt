package com.christianalbers.rockpaperscissorsbackend.service

import com.christianalbers.rockpaperscissorsbackend.dto.GameDto
import com.christianalbers.rockpaperscissorsbackend.dto.GameResultDTO
import com.christianalbers.rockpaperscissorsbackend.entity.Game
import com.christianalbers.rockpaperscissorsbackend.enums.GameResult
import com.christianalbers.rockpaperscissorsbackend.enums.GameSymbol
import com.christianalbers.rockpaperscissorsbackend.repository.GameRepository
import org.springframework.stereotype.Service

@Service
class GameService(private val gameRepository: GameRepository) {

    fun getAllGames(): List<Game> {
        return gameRepository.findAll()
    }

    fun saveNewGame(game: Game) {
        gameRepository.save(game)
    }

    fun playGame(game: GameDto): GameResultDTO {

        return GameResultDTO(GameResult.DEFEAT, GameSymbol.PAPER, GameSymbol.ROCK)
    }
}