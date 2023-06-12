package com.christianalbers.rockpaperscissorsbackend.dto

import com.christianalbers.rockpaperscissorsbackend.enums.GameSymbol

data class GameDto(
        val username: String,
        val userSymbol: String,
)