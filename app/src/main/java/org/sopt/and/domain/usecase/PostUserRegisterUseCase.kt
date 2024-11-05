package org.sopt.and.domain.usecase

import org.sopt.and.domain.model.UserIdEntity
import org.sopt.and.domain.model.UserRegisterEntity
import org.sopt.and.domain.repository.AuthRepository

class PostUserRegisterUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(userRegisterEntity: UserRegisterEntity): Result<UserIdEntity> =
        authRepository.postRegister(userRegisterEntity = userRegisterEntity)
}