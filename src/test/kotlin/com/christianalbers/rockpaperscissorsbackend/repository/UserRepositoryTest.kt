package com.christianalbers.rockpaperscissorsbackend.repository

import com.christianalbers.rockpaperscissorsbackend.entity.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class UserRepositoryTest(@Autowired private val userRepository: UserRepository) {

    @AfterEach
    fun tearDown() {
        userRepository.deleteAll()
    }

    @Test
    fun itShouldFindUserByUsername() {
        val user = User("testUser")
        userRepository.save(user)
        assertThat(userRepository.findByUsername(user.username)).isNotNull
    }


    @Test
    fun itShouldNotFindNonExistingUser() {
        val user = User("testUser")
        userRepository.save(user)
        assertThat(userRepository.findByUsername("test")).isNull()
    }
}