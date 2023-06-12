package com.christianalbers.rockpaperscissorsbackend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "users")
class User (

        @Id
        @Column(unique = true, nullable = false)
        val username: String,

        @Column(nullable = false)
        val createdAt: LocalDateTime = LocalDateTime.now(),

        )