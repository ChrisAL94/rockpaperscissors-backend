package com.christianalbers.rockpaperscissorsbackend.repository

import com.christianalbers.rockpaperscissorsbackend.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    fun findByUsername(username: String): User?
}