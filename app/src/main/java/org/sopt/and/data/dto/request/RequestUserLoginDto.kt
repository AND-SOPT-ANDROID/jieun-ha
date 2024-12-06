package org.sopt.and.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestUserLoginDto(
    @SerialName("username")
    val username: String,
    @SerialName("password")
    val password: String
)
