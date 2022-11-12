package com.best.sferaprojecttest.di

import com.best.sferaprojecttest.data.repository.ImageRepositoryImpl
import com.best.sferaprojecttest.data.repository.ProfileRepositoryImpl
import com.best.sferaprojecttest.domain.repository.ImageRepository
import com.best.sferaprojecttest.domain.repository.ProfileRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProfileRepository(profileRepositoryImpl: ProfileRepositoryImpl): ProfileRepository

    @Binds
    @Singleton
    abstract fun bindImageRepository(imageRepositoryImpl: ImageRepositoryImpl): ImageRepository
}