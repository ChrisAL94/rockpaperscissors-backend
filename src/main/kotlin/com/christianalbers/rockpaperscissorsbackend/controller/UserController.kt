package com.christianalbers.rockpaperscissorsbackend.controller

import com.christianalbers.rockpaperscissorsbackend.dto.GameHistoryDto
import com.christianalbers.rockpaperscissorsbackend.entity.User
import com.christianalbers.rockpaperscissorsbackend.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path=["api/v1/user"])
class UserController(private val userService: UserService) {

    @GetMapping()
    fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }

    @PostMapping()
    fun registerNewUser(@RequestBody username: String) {
        userService.addNewUser(username)
    }

    @GetMapping("gameHistory")
    fun getUserGameHistory(@RequestBody username: String): GameHistoryDto {
        return userService.getGameHistoryByUsername(username)
    }
}