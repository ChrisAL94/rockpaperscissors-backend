package com.christianalbers.rockpaperscissorsbackend.controller

import com.christianalbers.rockpaperscissorsbackend.dto.GameHistoryDto
import com.christianalbers.rockpaperscissorsbackend.service.GameHistoryService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["api/v1/gameHistory"])
class GameHistoryController(private val gameHistoryService: GameHistoryService) {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("{username}")
    fun getUserGameHistory(@PathVariable username: String): GameHistoryDto {
        logger.trace("Game history for $username is requested")
        return gameHistoryService.getGameHistoryByUsername(username)
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping()
    fun getAllUsersGameHistory(): Array<GameHistoryDto> {
        logger.trace("Game history for all users is requested")
        return gameHistoryService.getAllUsersGameHistory()
    }
}