package com.christianalbers.rockpaperscissorsbackend.dto

import com.christianalbers.rockpaperscissorsbackend.entity.User

data class GameHistoryDto(
        val user: String,
        val wins: Int,
        val defeats: Int,
        val ties: Int,
)