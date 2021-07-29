package com.example.myapplicationwithpaging3.retrofit

import android.content.Context
import androidx.room.Room
import com.example.myapplicationwithpaging3.database.UserDatabase
import com.example.myapplicationwithpaging3.retrofit.ApiService.Companion.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()!!

    @Provides
    @Singleton
    fun providesRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(ApiService::class.java)!!

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): UserDatabase =
        Room.databaseBuilder(context, UserDatabase::class.java, "userDatabase")
            .build()
}