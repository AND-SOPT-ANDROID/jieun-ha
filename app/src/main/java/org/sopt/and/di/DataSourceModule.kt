package org.sopt.and.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.and.data.datasource.local.WaveLocalDataSource
import org.sopt.and.data.datasourceImpl.local.WaveLocalDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsWaveLocalDataSource(waveLocalDataSourceImpl: WaveLocalDataSourceImpl): WaveLocalDataSource
}