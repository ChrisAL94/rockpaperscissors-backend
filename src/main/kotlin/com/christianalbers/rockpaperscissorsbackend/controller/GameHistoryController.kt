package com.christianalbers.rockpaperscissorsbackend.controller

import com.christianalbers.rockpaperscissorsbackend.dto.GameHistoryDto
import com.christianalbers.rockpaperscissorsbackend.service.GameHistoryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["api/v1/gameHistory"])
class GameHistoryController(private val gameHistoryService: GameHistoryService) {

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("{username}")
    fun getUserGameHistory(@PathVariable username: String): GameHistoryDto {
        return gameHistoryService.getGameHistoryByUsername(username)
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping()
    fun getAllUsersGameHistory(): Array<GameHistoryDto> {
        return gameHistoryService.getAllUsersGameHistory()
    }
}