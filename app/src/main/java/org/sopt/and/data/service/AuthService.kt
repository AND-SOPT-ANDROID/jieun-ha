package org.sopt.and.data.service

import org.sopt.and.data.model.request.RequestUserLoginDto
import org.sopt.and.data.model.request.RequestUserRegisterDto
import org.sopt.and.data.model.response.ResponseLoginTokenDto
import org.sopt.and.data.model.response.ResponseRegisterNumberDto
import org.sopt.and.util.base.BaseResponse
import org.sopt.and.util.base.NullableBaseRespone
import retrofit2.http.Body
import retrofit2.http.POST

import org.sopt.and.util.constant.ApiConstants.USER
import org.sopt.and.util.constant.ApiConstants.LOGIN

interface AuthService {
    @POST(USER)
    suspend fun postRegister(
        @Body body: RequestUserRegisterDto
    ): BaseResponse<ResponseRegisterNumberDto>

    @POST(LOGIN)
    suspend fun postLogin(
        @Body body: RequestUserLoginDto
    ): NullableBaseRespone<ResponseLoginTokenDto>
}