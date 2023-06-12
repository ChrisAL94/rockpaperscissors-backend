package com.christianalbers.rockpaperscissorsbackend.dto

import com.christianalbers.rockpaperscissorsbackend.entity.User
import com.christianalbers.rockpaperscissorsbackend.enums.GameSymbol
import jakarta.persistence.Column
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

data class GameDto(
        val user: User,
        val userSymbol: GameSymbol,
        val computerSymbol: GameSymbol,
        val result: GameSymbol,
)