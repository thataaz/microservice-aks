package com.microserviceaks.springboot.service

import com.microserviceaks.springboot.dto.UserDto
import com.microserviceaks.springboot.model.UserModel
import com.microserviceaks.springboot.repository.UserRepository
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    private val logger = LoggerFactory.getLogger(UserService::class.java)

    fun getAllUsers(): Iterable<UserModel> {
        logger.info("getUser")
        return userRepository.findAll()
    }
    fun getUserById(id: Long): UserModel? {
        return try {
            userRepository.findById(id).orElse(null)
        } catch (ex: EntityNotFoundException) {
            logger.error("User with id $id not found", ex)
            null
        } catch (ex: Exception) {
            logger.error("Error getting user with id $id", ex)
            throw RuntimeException("Error getting user with id $id", ex)
        }
    }

    fun create(userDto: UserDto): UserModel {
        val user = UserModel(name = userDto.name, email = userDto.email)
        return userRepository.save(user)
    }

    fun update(id: Long, userDto: UserDto): UserModel {
        val user = userRepository.findById(id)
            .orElseThrow { EntityNotFoundException("User not found with id $id") }
            .apply {
                name = userDto.name
                email = userDto.email
            }
        return userRepository.save(user)
    }
}