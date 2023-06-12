package com.christianalbers.rockpaperscissorsbackend.repository

import com.christianalbers.rockpaperscissorsbackend.entity.Game
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GameRepository : JpaRepository<Game, Long> {}