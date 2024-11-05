package org.sopt.and.data.service

import org.sopt.and.data.model.response.ResponseHobbyDto
import org.sopt.and.data.service.AuthService.Companion.USER
import org.sopt.and.presentation.util.NullableBaseRespone
import retrofit2.http.GET

interface MyService {
    @GET("/$USER/$HOBBY")
    suspend fun getMyHobby(): NullableBaseRespone<ResponseHobbyDto>

    companion object {
        const val HOBBY = "my-hobby"
    }
}