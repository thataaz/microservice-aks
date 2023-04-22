package com.microserviceaks.springboot.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Email

@Entity
@Table(name = "table_user")
data class UserModel (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,

    @NotEmpty(message = "Name is required")
    val name: String? = null,

    @NotEmpty(message = "Email is required")
    @Email(message = "Email is invalid")
    val email: String? = null
)
