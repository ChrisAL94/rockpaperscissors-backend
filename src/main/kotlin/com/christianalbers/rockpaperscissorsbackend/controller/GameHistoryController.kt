package com.christianalbers.rockpaperscissorsbackend.controller

import com.christianalbers.rockpaperscissorsbackend.dto.GameHistoryDto
import com.christianalbers.rockpaperscissorsbackend.service.GameHistoryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["api/v1/gameHistory"])
class GameHistoryController(private val gameHistoryService: GameHistoryService) {

    @GetMapping("userGameHistory")
    fun getUserGameHistory(@RequestBody username: String): GameHistoryDto {
        return gameHistoryService.getGameHistoryByUsername(username)
    }

    @GetMapping()
    fun getAllUsersGameHistory(): Array<GameHistoryDto> {
        return gameHistoryService.getAllUsersGameHistory()
    }
}