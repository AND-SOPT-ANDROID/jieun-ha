package org.sopt.and.domain.model

import org.sopt.and.data.model.request.RequestUserLoginDto

data class UserLoginEntity(
    val username: String,
    val userPassword: String
) {
    fun toRequestUserLoginDto() = RequestUserLoginDto(
        username = username,
        password = userPassword
    )
}