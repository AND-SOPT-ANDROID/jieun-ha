package org.sopt.and.presentation.util

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NullableBaseRespone<T>(
    @SerialName("code")
    val code: String? = null,
    @SerialName("message")
    val message: String? = null,
    @SerialName("result")
    val result: T
)