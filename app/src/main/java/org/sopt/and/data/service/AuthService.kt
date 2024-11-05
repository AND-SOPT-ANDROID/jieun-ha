package org.sopt.and.data.service

import org.sopt.and.data.model.request.RequestUserLoginDto
import org.sopt.and.data.model.request.RequestUserRegisterDto
import org.sopt.and.data.model.response.ResponseLoginTokenDto
import org.sopt.and.data.model.response.ResponseRegisterNumberDto
import org.sopt.and.presentation.util.BaseResponse
import org.sopt.and.presentation.util.NullableBaseRespone
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("/$USER")
    suspend fun postRegister(
        @Body body: RequestUserRegisterDto
    ): BaseResponse<ResponseRegisterNumberDto>

    @POST("/$LOGIN")
    suspend fun postLogin(
        @Body body: RequestUserLoginDto
    ): NullableBaseRespone<ResponseLoginTokenDto>

    companion object {
        const val USER = "user"
        const val LOGIN = "login"
    }
}