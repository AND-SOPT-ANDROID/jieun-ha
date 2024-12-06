package org.sopt.and.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.and.domain.repository.AuthRepository
import org.sopt.and.domain.repository.MyRepository
import org.sopt.and.domain.usecase.PatchUserHobbyUseCase
import org.sopt.and.domain.usecase.PatchUserLoginUseCase
import org.sopt.and.domain.usecase.PatchUserRegisterUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun providesPostUserRegisterUseCase(authRepository: AuthRepository): PatchUserRegisterUseCase =
        PatchUserRegisterUseCase(authRepository = authRepository)

    @Provides
    @Singleton
    fun providesPostUserLoginUseCase(authRepository: AuthRepository): PatchUserLoginUseCase =
        PatchUserLoginUseCase(authRepository = authRepository)

    @Provides
    @Singleton
    fun providesGetUserHobbyUseCase(myRepository: MyRepository): PatchUserHobbyUseCase =
        PatchUserHobbyUseCase(myRepository = myRepository)
}