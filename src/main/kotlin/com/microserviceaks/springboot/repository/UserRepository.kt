package com.microserviceaks.springboot.repository

import com.microserviceaks.springboot.model.UserModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<UserModel, Long> 