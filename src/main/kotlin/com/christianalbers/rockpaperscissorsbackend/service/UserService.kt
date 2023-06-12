package com.christianalbers.rockpaperscissorsbackend.service

import com.christianalbers.rockpaperscissorsbackend.entity.User
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService {

    fun getUser(): User {
        return User("testUser1", LocalDateTime.now());
    }
}