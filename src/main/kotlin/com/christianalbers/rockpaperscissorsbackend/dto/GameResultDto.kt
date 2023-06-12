package com.christianalbers.rockpaperscissorsbackend.dto

import com.christianalbers.rockpaperscissorsbackend.enums.GameResult
import com.christianalbers.rockpaperscissorsbackend.enums.GameSymbol


data class GameResultDTO(
        val result: GameResult,
        val computerSymbol: GameSymbol,
)