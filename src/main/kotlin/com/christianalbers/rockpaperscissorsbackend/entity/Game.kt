package com.christianalbers.rockpaperscissorsbackend.entity

import com.christianalbers.rockpaperscissorsbackend.enums.GameResult
import com.christianalbers.rockpaperscissorsbackend.enums.GameSymbol
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "games")
class Game(

        @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        @JoinColumn(name = "user_id", nullable = false)
        val user: User,

        @Column(nullable = false)
        val userSymbol: GameSymbol,

        @Column(nullable = false)
        val computerSymbol: GameSymbol,

        @Column(nullable = false)
        val result: GameResult,

        @Column(nullable = false)
        val createdAt: LocalDateTime = LocalDateTime.now(),

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val gameId: Long = 0,
)
