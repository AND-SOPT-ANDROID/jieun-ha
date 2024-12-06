package org.sopt.and.data.datasourceImpl.remote

import org.sopt.and.data.datasource.remote.AuthRemoteDataSource
import org.sopt.and.data.model.request.RequestUserLoginDto
import org.sopt.and.data.model.request.RequestUserRegisterDto
import org.sopt.and.data.model.response.ResponseLoginTokenDto
import org.sopt.and.data.model.response.ResponseRegisterNumberDto
import org.sopt.and.data.service.AuthService
import org.sopt.and.util.base.BaseResponse
import org.sopt.and.util.base.NullableBaseRespone
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(
    private val authService: AuthService
) : AuthRemoteDataSource {
    override suspend fun register(requestUserRegisterDto: RequestUserRegisterDto): BaseResponse<ResponseRegisterNumberDto> =
        authService.postRegister(requestUserRegisterDto)

    override suspend fun login(requestUserLoginDto: RequestUserLoginDto): NullableBaseRespone<ResponseLoginTokenDto> =
        authService.postLogin(requestUserLoginDto)
}