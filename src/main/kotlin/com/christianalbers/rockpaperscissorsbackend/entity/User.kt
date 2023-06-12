package com.christianalbers.rockpaperscissorsbackend.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "users")
class User(

        @Column(unique = true, nullable = false)
        val username: String,

        @Column(nullable = false)
        val createdAt: LocalDateTime = LocalDateTime.now(),

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val userId: Long = 0,
)