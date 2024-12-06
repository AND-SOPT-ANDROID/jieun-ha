package org.sopt.and.domain.usecase

import org.sopt.and.domain.model.UserEntity
import org.sopt.and.domain.model.UserLoginEntity
import org.sopt.and.domain.repository.AuthRepository

class PatchUserLoginUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(userLoginEntity: UserLoginEntity): Result<UserEntity> =
        authRepository.postLogin(userLoginEntity = userLoginEntity)
}