package org.sopt.and.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.sopt.and.domain.model.UserEntity

@Serializable
data class ResponseLoginTokenDto(
    @SerialName("token")
    val accessToken: String
) {
    fun toUserEntity() = UserEntity(
        accessToken = accessToken
    )
}
