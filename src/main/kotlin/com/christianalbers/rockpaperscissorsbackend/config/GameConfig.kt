package com.christianalbers.rockpaperscissorsbackend.config

import com.christianalbers.rockpaperscissorsbackend.entity.Game
import com.christianalbers.rockpaperscissorsbackend.enums.GameResult
import com.christianalbers.rockpaperscissorsbackend.enums.GameSymbol
import com.christianalbers.rockpaperscissorsbackend.repository.GameRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GameConfig {

    @Bean
    fun commandLineRunnerGame(repository: GameRepository, userConfig: UserConfig): CommandLineRunner {
        return CommandLineRunner {
            val game1 = Game(userConfig.testUser1, GameSymbol.ROCK, GameSymbol.PAPER, GameResult.DEFEAT)
            val game2 = Game(userConfig.testUser1, GameSymbol.ROCK, GameSymbol.ROCK, GameResult.TIE)
            val game3 = Game(userConfig.testUser1, GameSymbol.ROCK, GameSymbol.SCISSORS, GameResult.WIN)
            val game4 = Game(userConfig.testUser2, GameSymbol.PAPER, GameSymbol.PAPER, GameResult.TIE)
            val game5 = Game(userConfig.testUser2, GameSymbol.PAPER, GameSymbol.PAPER, GameResult.TIE)
            val game6 = Game(userConfig.testUser3, GameSymbol.ROCK, GameSymbol.SCISSORS, GameResult.WIN)
            val game7 = Game(userConfig.testUser4, GameSymbol.ROCK, GameSymbol.SCISSORS, GameResult.WIN)
            val game8 = Game(userConfig.testUser4, GameSymbol.SCISSORS, GameSymbol.PAPER, GameResult.WIN)
            val game9 = Game(userConfig.testUser4, GameSymbol.SCISSORS, GameSymbol.PAPER, GameResult.WIN)
            val game10 = Game(userConfig.testUser5, GameSymbol.ROCK, GameSymbol.PAPER, GameResult.WIN)
            repository.saveAll(listOf(game1, game2, game3, game4, game5, game6, game7, game8, game9, game10))
        }
    }
}