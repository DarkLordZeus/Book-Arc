package com.example.bookarc.network

import com.example.bookarc.bookarcmodel.Bookarc
import retrofit2.http.GET
import retrofit2.http.Query


interface Booksarc {
    @GET("books/v1/volumes")
    suspend fun getbooks(
        @Query("q") query: String,
        @Query("key") key:String
    ):Bookarc

    @GET("books/v1/volumes?q=crime+romance+action+mystery+young+fiction+thrill+adventure&orderBy=newest&printType=books&maxResults=30")
    suspend fun getNewReleaseBooks():Bookarc
}