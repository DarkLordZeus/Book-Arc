package com.example.bookarc.components

import com.example.bookarc.bookarcmodel.Item

data class Mainstate(
    val isLoading:Boolean=false,
    val data:List<Item> = emptyList(),
    val error:String=""
)
