package org.sopt.and.data.repositoryImpl

import org.sopt.and.data.datasource.remote.AuthRemoteDataSource
import org.sopt.and.domain.model.UserIdEntity
import org.sopt.and.domain.model.UserRegisterEntity
import org.sopt.and.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource
) : AuthRepository {
    override suspend fun postRegister(userRegisterEntity: UserRegisterEntity): Result<UserIdEntity> =
        runCatching {
            authRemoteDataSource.register(requestUserRegisterDto = userRegisterEntity.toRequestUserRegisterDto()).result.toUserIdEntity()
        }
}