package com.christianalbers.rockpaperscissorsbackend.dto

import com.christianalbers.rockpaperscissorsbackend.enums.GameSymbol
import org.springframework.lang.NonNull

data class GameDto(
        val username: String,
        val userSymbol: String,
)