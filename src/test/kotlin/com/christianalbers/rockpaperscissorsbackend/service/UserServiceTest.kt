package com.christianalbers.rockpaperscissorsbackend.service

import com.christianalbers.rockpaperscissorsbackend.entity.User
import com.christianalbers.rockpaperscissorsbackend.repository.UserRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.any
import org.mockito.BDDMockito.given
import org.mockito.Mockito.never
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class UserServiceTest(@Mock private val userRepository: UserRepository) {

    private lateinit var userService: UserService;

    @BeforeEach
    fun setUp() {
        this.userService = UserService(userRepository)
    }

    @Test
    fun getAllUsers() {
        userService.getAllUsers()
        Mockito.verify(userRepository).findAll()
    }

    @Test
    fun addNewUser() {
        userService.addNewUser("testUser")
        val userArgumentCapture: ArgumentCaptor<User> = ArgumentCaptor.forClass(User::class.java);
        Mockito.verify(userRepository).save(userArgumentCapture.capture())
        val capturedUser = userArgumentCapture.value
        assertThat(capturedUser.username).isEqualTo("testUser")
    }

    @Test
    fun willThrowWhenUsernameIsTaken() {
        given(userRepository.findByUsername("testUser")).willReturn(User("testUser"))
        assertThatThrownBy { userService.addNewUser("testUser") }.isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("username is already taken.")

        Mockito.verify(userRepository, never()).save(any())
    }
}