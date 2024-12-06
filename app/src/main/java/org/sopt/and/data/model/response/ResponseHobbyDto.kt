package org.sopt.and.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.sopt.and.domain.model.UserHobbyEntity

@Serializable
data class ResponseHobbyDto(
    @SerialName("hobby")
    val hobby: String
) {
    fun toUserHobbyEntity() = UserHobbyEntity(
        hobby = hobby
    )
}
