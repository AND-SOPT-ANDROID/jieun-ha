package org.sopt.and.domain.usecase

import org.sopt.and.domain.model.UserHobbyEntity
import org.sopt.and.domain.repository.MyRepository

class GetUserHobbyUseCase(
    private val myRepository: MyRepository
) {
    suspend operator fun invoke(): Result<UserHobbyEntity> =
        myRepository.getMyHobby()
}