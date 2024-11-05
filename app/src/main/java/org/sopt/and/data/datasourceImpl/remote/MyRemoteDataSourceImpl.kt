package org.sopt.and.data.datasourceImpl.remote

import org.sopt.and.data.datasource.remote.MyRemoteDataSource
import org.sopt.and.data.model.response.ResponseHobbyDto
import org.sopt.and.data.service.MyService
import org.sopt.and.presentation.util.NullableBaseRespone
import javax.inject.Inject

class MyRemoteDataSourceImpl @Inject constructor(
    private val myService: MyService
) : MyRemoteDataSource {
    override suspend fun getMyHobby(): NullableBaseRespone<ResponseHobbyDto> =
        myService.getMyHobby()
}