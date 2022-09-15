package com.example.bookarc.bookarcmodel

data class Bookarc(
    val items: List<Item>,
    val kind: String,
    val totalItems: Long
)