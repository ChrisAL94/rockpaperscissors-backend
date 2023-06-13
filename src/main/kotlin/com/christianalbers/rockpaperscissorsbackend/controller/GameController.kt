package com.christianalbers.rockpaperscissorsbackend.controller

import com.christianalbers.rockpaperscissorsbackend.dto.GameDto
import com.christianalbers.rockpaperscissorsbackend.dto.GameResultDTO
import com.christianalbers.rockpaperscissorsbackend.enums.GameSymbol
import com.christianalbers.rockpaperscissorsbackend.service.GameService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path=["api/v1/game"])
class GameController(private val gameService: GameService) {

    @PostMapping()
    fun playGame(gameDto: Any): GameResultDTO {
        val game = GameDto("testUser1", "ROCK")
        return gameService.playGame(game)
    }
}