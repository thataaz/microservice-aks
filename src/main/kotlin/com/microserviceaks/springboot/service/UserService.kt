package com.microserviceaks.springboot.service

import com.microserviceaks.springboot.repository.UserRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    private val userRepository: UserRepository

    fun getUser(): Iterable<UserModel> = userRepository.findAll()
    
}