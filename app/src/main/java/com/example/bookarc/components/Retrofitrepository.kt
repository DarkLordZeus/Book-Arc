package com.example.bookarc.components

import android.nfc.Tag
import android.util.Log
import com.example.bookarc.bookarcmodel.Bookarc
import com.example.bookarc.network.Booksarc
import com.example.bookarc.network.Resource
import com.example.bookarc.util.API_KEY
import java.lang.Exception
import javax.inject.Inject

class Retrofitrepository @Inject constructor(private val booksarc: Booksarc) {
    suspend fun getsearchedbooks(q:String):Resource<Bookarc>{
        return try {
            val result = booksarc.getbooks(q, API_KEY)
            Resource.Success(data = result)
        }
        catch (e:Exception) {
            Resource.Error(message = e.message.toString())
        }
    }
    suspend fun gettrendingbooks():Resource<Bookarc>{
        return try {
            val result = booksarc.getNewReleaseBooks()
            Log.d("TAG","WORKSHERE")
            Resource.Success(data = result)
        }
        catch (e:Exception) {
            Log.d("TAG","${e.message.toString()}")
            Resource.Error(message = e.message.toString())
        }
    }
}