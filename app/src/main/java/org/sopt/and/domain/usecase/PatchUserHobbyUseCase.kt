package org.sopt.and.domain.usecase

import org.sopt.and.domain.model.UserHobbyEntity
import org.sopt.and.domain.repository.MyRepository

class PatchUserHobbyUseCase(
    private val myRepository: MyRepository
) {
    suspend operator fun invoke(): UserHobbyEntity =
        myRepository.getMyHobby()
}