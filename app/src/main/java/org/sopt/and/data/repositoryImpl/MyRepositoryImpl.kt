package org.sopt.and.data.repositoryImpl

import org.sopt.and.data.datasource.remote.MyRemoteDataSource
import org.sopt.and.domain.model.UserHobbyEntity
import org.sopt.and.domain.repository.MyRepository
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val myRemoteDataSource: MyRemoteDataSource
) : MyRepository {
    override suspend fun getMyHobby(): UserHobbyEntity =
        myRemoteDataSource.getMyHobby().result.toUserHobbyEntity()
}