package org.sopt.and.data.service

import org.sopt.and.data.model.response.ResponseHobbyDto
import org.sopt.and.util.base.NullableBaseRespone
import retrofit2.http.GET
import org.sopt.and.util.constant.ApiConstants.USER
import org.sopt.and.util.constant.ApiConstants.HOBBY

interface MyService {
    @GET("$USER/$HOBBY")
    suspend fun getMyHobby(): NullableBaseRespone<ResponseHobbyDto>
}