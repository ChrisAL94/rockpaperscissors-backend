package com.christianalbers.rockpaperscissorsbackend.service

import com.christianalbers.rockpaperscissorsbackend.dto.GameDto
import com.christianalbers.rockpaperscissorsbackend.dto.GameResultDTO
import com.christianalbers.rockpaperscissorsbackend.entity.Game
import com.christianalbers.rockpaperscissorsbackend.entity.User
import com.christianalbers.rockpaperscissorsbackend.enums.GameResult
import com.christianalbers.rockpaperscissorsbackend.enums.GameSymbol
import com.christianalbers.rockpaperscissorsbackend.repository.GameRepository
import com.christianalbers.rockpaperscissorsbackend.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class GameService(private val gameRepository: GameRepository, private val userRepository: UserRepository) {

    fun getAllGames(): List<Game> {
        return gameRepository.findAll()
    }

    fun playGame(gameDto: GameDto): GameResultDTO {
        val gameResult = this.determineWinner(GameSymbol.valueOf(gameDto.userSymbol))
        val user = userRepository.findByUsername(gameDto.username)
                ?: throw IllegalStateException("There is no user under this username")
        gameRepository.save(Game(user, GameSymbol.valueOf(gameDto.userSymbol), gameResult.computerSymbol, gameResult.result, LocalDateTime.now()))
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