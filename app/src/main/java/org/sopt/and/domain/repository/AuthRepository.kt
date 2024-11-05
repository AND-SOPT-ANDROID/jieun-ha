package org.sopt.and.domain.repository

import org.sopt.and.domain.model.UserIdEntity
import org.sopt.and.domain.model.UserRegisterEntity

interface AuthRepository {
    suspend fun postRegister(userRegisterEntity: UserRegisterEntity): Result<UserIdEntity>
}