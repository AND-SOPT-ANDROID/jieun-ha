package org.sopt.and.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.and.domain.repository.AuthRepository
import org.sopt.and.domain.usecase.PostUserRegisterUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun providesUserRegisterUseCase(authRepository: AuthRepository): PostUserRegisterUseCase =
        PostUserRegisterUseCase(authRepository = authRepository)
}