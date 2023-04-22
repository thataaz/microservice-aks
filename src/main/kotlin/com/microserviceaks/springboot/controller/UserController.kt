package com.microserviceaks.springboot.controller

import com.microserviceaks.springboot.dto.UserDto
import com.microserviceaks.springboot.model.UserModel
import com.microserviceaks.springboot.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("v1/users")
class UserController {
    @Autowired
    private lateinit var userService: UserService

    @GetMapping
    fun getUsers(): ResponseEntity<Iterable<UserModel>> = ResponseEntity.ok(userService.getAllUsers())

    @GetMapping("/{id}")
    fun getUser(id: Long): ResponseEntity<UserModel> = ResponseEntity.ok(userService.getUserById(id))

    @PostMapping
    fun createUser(@RequestBody @Valid userDto: UserDto): ResponseEntity<UserModel> {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userDto))
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody @Valid userDto: UserDto): ResponseEntity<UserModel> {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(id, userDto))
    }

    @DeleteMapping("/{id}")
    fun deleteUser(id: Long): ResponseEntity<UserModel> {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(userService.delete(id))
    }
}