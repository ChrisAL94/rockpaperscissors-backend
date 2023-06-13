package com.christianalbers.rockpaperscissorsbackend.controller

import com.christianalbers.rockpaperscissorsbackend.dto.GameDto
import com.christianalbers.rockpaperscissorsbackend.dto.GameResultDTO
import com.christianalbers.rockpaperscissorsbackend.service.GameService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path=["api/v1/game"])
class GameController(private val gameService: GameService) {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @CrossOrigin(origins = ["http://localhost:4200"])
    @PostMapping()
    fun playGame(gameDto: GameDto): GameResultDTO {
        logger.trace("Game endpoint is accessed by ${gameDto.username} with symbol ${gameDto.userSymbol}")
        return gameService.playGame(gameDto)
    }
}