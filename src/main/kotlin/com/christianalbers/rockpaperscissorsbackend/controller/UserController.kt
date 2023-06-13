package com.christianalbers.rockpaperscissorsbackend.controller

import com.christianalbers.rockpaperscissorsbackend.dto.GameHistoryDto
import com.christianalbers.rockpaperscissorsbackend.entity.User
import com.christianalbers.rockpaperscissorsbackend.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path=["api/v1/user"])
class UserController(private val userService: UserService) {

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping()
    fun getAllUsers(): List<String> {
        return userService.getAllUsers()
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @PostMapping()
    fun registerNewUser(@RequestBody username: String) {
        userService.addNewUser(username)
    }
}