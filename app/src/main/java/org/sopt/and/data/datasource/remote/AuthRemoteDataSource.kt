package org.sopt.and.data.datasource.remote

import org.sopt.and.data.dto.request.RequestUserLoginDto
import org.sopt.and.data.dto.request.RequestUserRegisterDto
import org.sopt.and.data.dto.response.ResponseLoginTokenDto
import org.sopt.and.data.dto.response.ResponseRegisterNumberDto
import org.sopt.and.util.base.BaseResponse
import org.sopt.and.util.base.NullableBaseRespone

interface AuthRemoteDataSource {
    suspend fun register(requestUserRegisterDto: RequestUserRegisterDto): BaseResponse<ResponseRegisterNumberDto>

    suspend fun login(requestUserLoginDto: RequestUserLoginDto): NullableBaseRespone<ResponseLoginTokenDto>
}