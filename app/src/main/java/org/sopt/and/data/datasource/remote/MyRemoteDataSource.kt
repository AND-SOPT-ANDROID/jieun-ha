package org.sopt.and.data.datasource.remote

import org.sopt.and.data.model.response.ResponseHobbyDto
import org.sopt.and.presentation.util.NullableBaseRespone

interface MyRemoteDataSource {
    suspend fun getMyHobby(): NullableBaseRespone<ResponseHobbyDto>
}