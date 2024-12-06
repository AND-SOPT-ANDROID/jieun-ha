package org.sopt.and.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.sopt.and.domain.model.UserIdEntity

@Serializable
data class ResponseRegisterNumberDto(
    @SerialName("no")
    val userId : Long
) {
    fun toUserIdEntity() = UserIdEntity(
        id = userId
    )
}
