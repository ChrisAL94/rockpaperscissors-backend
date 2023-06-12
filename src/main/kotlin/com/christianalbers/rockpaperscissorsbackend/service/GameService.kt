package com.christianalbers.rockpaperscissorsbackend.service

import com.christianalbers.rockpaperscissorsbackend.dto.GameDto
import com.christianalbers.rockpaperscissorsbackend.dto.GameResultDTO
import com.christianalbers.rockpaperscissorsbackend.entity.Game
import com.christianalbers.rockpaperscissorsbackend.enums.GameResult
import com.christianalbers.rockpaperscissorsbackend.enums.GameSymbol
import com.christianalbers.rockpaperscissorsbackend.repository.GameRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class GameService(private val gameRepository: GameRepository) {

    fun getAllGames(): List<Game> {
        return gameRepository.findAll()
    }

    fun playGame(gameDto: GameDto): GameResultDTO {
        val gameResult = this.determineWinner(gameDto.userSymbol)
        gameRepository.save(Game(gameDto.user, gameDto.userSymbol, gameResult.computerSymbol, gameResult.result, LocalDateTime.now()))
        return GameResultDTO(gameResult.result, gameResult.computerSymbol)
    }

    fun determineWinner(userChoice: GameSymbol): GameResultDTO {
        val computerChoice = GameSymbol.values()[(0..2).random()]
        val gameResult: GameResult = when {
            userChoice == computerChoice -> GameResult.TIE
            userChoice == GameSymbol.ROCK && computerChoice == GameSymbol.SCISSORS ||
                    userChoice == GameSymbol.PAPER && computerChoice == GameSymbol.ROCK ||
                    userChoice == GameSymbol.SCISSORS && computerChoice == GameSymbol.PAPER -> GameResult.WIN
            else -> GameResult.DEFEAT
        }

        return GameResultDTO(gameResult, computerChoice)
    }
}