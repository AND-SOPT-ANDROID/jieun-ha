package org.sopt.and.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.and.data.datasource.local.WaveLocalDataSource
import org.sopt.and.data.datasource.remote.AuthRemoteDataSource
import org.sopt.and.data.datasourceImpl.local.WaveLocalDataSourceImpl
import org.sopt.and.data.datasourceImpl.remote.AuthRemoteDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsWaveLocalDataSource(waveLocalDataSourceImpl: WaveLocalDataSourceImpl): WaveLocalDataSource

    @Binds
    @Singleton
    abstract fun bindsAuthRemoteDataSource(authRemoteDataSourceImpl: AuthRemoteDataSourceImpl): AuthRemoteDataSource
}