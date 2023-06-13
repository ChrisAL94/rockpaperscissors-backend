package com.christianalbers.rockpaperscissorsbackend.controller

import com.christianalbers.rockpaperscissorsbackend.dto.GameHistoryDto
import com.christianalbers.rockpaperscissorsbackend.entity.User
import com.christianalbers.rockpaperscissorsbackend.service.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path=["api/v1/user"])
class UserController(private val userService: UserService) {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)


    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping()
    fun getAllUsers(): List<String> {
        logger.trace("Registered users are requested")
        return userService.getAllUsers()
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @PostMapping()
    fun registerNewUser(@RequestBody username: String) {
        logger.trace("$username access registration endpoint")
        userService.addNewUser(username)
    }
}