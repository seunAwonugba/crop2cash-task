package com.example.crop2cash.di

import com.example.crop2cash.remote.ExhibitsLoader
import com.example.crop2cash.repository.ExhibitRepository
import com.example.crop2cash.repository.ExhibitRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideWebService(retrofit: Retrofit) : ExhibitsLoader = retrofit.create()


    @Singleton
    @Provides
    fun provideExhibitRepository(exhibitsLoader: ExhibitsLoader) : ExhibitRepository{
        return ExhibitRepositoryImpl(exhibitsLoader = exhibitsLoader)
    }
}