package com.example.bookarc.network

import com.example.bookarc.components.Retrofitrepository
import com.example.bookarc.util.Base_Url
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object HiltModule {

    @Singleton
    @Provides
    fun provideapiservice():Booksarc{
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
            return Retrofit.Builder().baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create()).client(client).build()
                .create(Booksarc::class.java)
    }

    @Provides
    fun provideretrorepo(booksarc: Booksarc):Retrofitrepository{
        return Retrofitrepository(booksarc = booksarc)
    }

}