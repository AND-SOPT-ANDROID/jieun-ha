package org.sopt.and.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.and.domain.repository.AuthRepository
import org.sopt.and.domain.repository.MyRepository
import org.sopt.and.domain.usecase.GetUserHobbyUseCase
import org.sopt.and.domain.usecase.PostUserLoginUseCase
import org.sopt.and.domain.usecase.PostUserRegisterUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun providesPostUserRegisterUseCase(authRepository: AuthRepository): PostUserRegisterUseCase =
        PostUserRegisterUseCase(authRepository = authRepository)

    @Provides
    @Singleton
    fun providesPostUserLoginUseCase(authRepository: AuthRepository): PostUserLoginUseCase =
        PostUserLoginUseCase(authRepository = authRepository)

    @Provides
    @Singleton
    fun providesGetUserHobbyUseCase(myRepository: MyRepository): GetUserHobbyUseCase =
        GetUserHobbyUseCase(myRepository = myRepository)
}