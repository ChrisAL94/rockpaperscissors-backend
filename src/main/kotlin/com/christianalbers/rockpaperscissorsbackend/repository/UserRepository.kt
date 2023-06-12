package com.christianalbers.rockpaperscissorsbackend.repository

import com.christianalbers.rockpaperscissorsbackend.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
public interface userRepository : JpaRepository<User, String> {}