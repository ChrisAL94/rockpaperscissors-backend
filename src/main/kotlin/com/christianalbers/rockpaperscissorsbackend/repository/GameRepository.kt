package com.christianalbers.rockpaperscissorsbackend.repository

import com.christianalbers.rockpaperscissorsbackend.entity.Game
import com.christianalbers.rockpaperscissorsbackend.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface GameRepository : JpaRepository<Game, Long> {

    @Query("SELECT g FROM Game g WHERE g.user.username = ?1")
    fun findByUsername(username: String): List<Game>?

    @Query("SELECT DISTINCT g.user.username FROM Game g")
    fun findAllUsernames(): List<String>?
}