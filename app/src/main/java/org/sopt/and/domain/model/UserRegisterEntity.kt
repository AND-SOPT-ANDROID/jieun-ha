package org.sopt.and.domain.model

import org.sopt.and.data.dto.request.RequestUserRegisterDto

data class UserRegisterEntity(
    val username: String,
    val userPassword: String,
    val userHobby: String
) {
    fun toRequestUserRegisterDto() = RequestUserRegisterDto(
        username = username,
        password = userPassword,
        hobby = userHobby
    )
}
