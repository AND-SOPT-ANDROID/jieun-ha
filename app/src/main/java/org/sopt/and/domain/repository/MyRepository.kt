package org.sopt.and.domain.repository

import org.sopt.and.domain.model.UserHobbyEntity

interface MyRepository {
    suspend fun getMyHobby(): Result<UserHobbyEntity>
}