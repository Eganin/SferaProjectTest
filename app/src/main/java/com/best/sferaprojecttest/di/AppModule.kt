package com.best.sferaprojecttest.di

import android.content.Context
import com.best.sferaprojecttest.R
import com.best.sferaprojecttest.data.api.AnimeApi
import com.best.sferaprojecttest.domain.repository.ProfileRepository
import com.best.sferaprojecttest.domain.usecases.*
import com.best.sferaprojecttest.presentation.fragments.people.adapters.PeopleAdapter
import com.best.sferaprojecttest.presentation.fragments.profile.adapters.ChroniciesAdapter
import com.best.sferaprojecttest.presentation.fragments.profile.adapters.MomentsAdapter
import com.best.sferaprojecttest.presentation.fragments.profile.adapters.ProfileImagesAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
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
    fun provideUseCases(repository: ProfileRepository): SferaUseCases {
        return SferaUseCases(
            getPeoplesInfo = GetPeopleInfo(repository = repository),
            getProfileInfo = GetProfileInfo(repository = repository),
            getProfileImages = GetProfileImages(repository = repository),
            getMoments = GetMoments(repository = repository),
            getChronicies = GetChronicies(repository = repository),
            updatePeopleInfoAndGetPeoplesInfo = UpdatePeopleInfoAndGetPeoplesInfo(repository = repository)
        )
    }

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(level = HttpLoggingInterceptor.Level.BODY)
            )
            .build()

    @Provides
    @Singleton
    fun provideProductApi(client: OkHttpClient): AnimeApi {

        return Retrofit.Builder()
            .baseUrl("https://api.waifu.im")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }
}