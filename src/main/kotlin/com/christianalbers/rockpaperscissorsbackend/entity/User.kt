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
        @SequenceGenerator(
                name = "user_sequence",
                sequenceName = "user_sequence",
                allocationSize = 1,
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "user_sequence",
        )
        val id: Long = 0,
)