package com.example.feedpage.di

import com.example.feedpage.data.remote.PostApi
import com.example.feedpage.data.repository.FeedRepositoryImplementation
import com.example.feedpage.domain.repository.FeedRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FeedModule {

    @Provides
    @Singleton
    fun providePostApi(): PostApi {
        return Retrofit.Builder()
            .baseUrl("https://api.json-generator.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFeedRepository(
        api: PostApi
    ): FeedRepository {
        return FeedRepositoryImplementation(api = api)
    }

}