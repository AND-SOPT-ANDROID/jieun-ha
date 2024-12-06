package org.sopt.and.domain.repository

import org.sopt.and.domain.model.UserEntity
import org.sopt.and.domain.model.UserIdEntity
import org.sopt.and.domain.model.UserLoginEntity
import org.sopt.and.domain.model.UserRegisterEntity

interface AuthRepository {
    suspend fun postRegister(userRegisterEntity: UserRegisterEntity): Result<UserIdEntity>
    suspend fun postLogin(userLoginEntity: UserLoginEntity): Result<UserEntity>
}