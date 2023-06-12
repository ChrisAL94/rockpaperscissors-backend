package com.christianalbers.rockpaperscissorsbackend.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "games")
class Game(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val gameId: Long = 0,

        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        val user: User,

        @Column(nullable = false)
        val userSymbol: String,

        @Column(nullable = false)
        val computerSymbol: String,

        @Column(nullable = false)
        val result: String,

        @Column(nullable = false)
        val createdAt: LocalDateTime = LocalDateTime.now(),
)