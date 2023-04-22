package com.microserviceaks.springboot.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Email
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Table(name = "table_user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class UserModel {

        @Id 
        @GeneratedValue(strategy = GenerationType.AUTO) 
        val id: Int = 0

        @NotEmpty(message = "Name is required")
        val name: String? = null

        @NotEmpty(message = "Email is required")
        @Email(message = "Email is invalid")
        val email: String? = null
}
