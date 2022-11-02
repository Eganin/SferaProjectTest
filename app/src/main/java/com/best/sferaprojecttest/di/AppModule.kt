package com.best.sferaprojecttest.di

import android.content.Context
import com.best.sferaprojecttest.R
import com.best.sferaprojecttest.presentation.fragments.people.adapters.PeopleAdapter
import com.best.sferaprojecttest.presentation.fragments.profile.adapters.ChroniciesAdapter
import com.best.sferaprojecttest.presentation.fragments.profile.adapters.MomentsAdapter
import com.best.sferaprojecttest.presentation.fragments.profile.adapters.ProfileImagesAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideGlideInstance(
        @ApplicationContext context: Context
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions()
            .placeholder(R.drawable.ic_image)
            .error(R.drawable.ic_image)
    )

    @Singleton
    @Provides
    fun provideProfileAdapter(glide: RequestManager) = ProfileImagesAdapter(glide = glide)

    @Singleton
    @Provides
    fun provideMomentsAdapter(glide: RequestManager) = MomentsAdapter(glide = glide)

    @Singleton
    @Provides
    fun provideChroniciesAdapter(glide: RequestManager) = ChroniciesAdapter(glide = glide)

    @Singleton
    @Provides
    fun providePeopleAdapter(glide: RequestManager) = PeopleAdapter(glide = glide)
}