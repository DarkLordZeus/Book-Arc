package com.example.bookarc.bookarcmodel

import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfo(
    val allowAnonLogging: Boolean,
    val authors: List<String>,  //this
    val averageRating: Float,  //this
    val canonicalVolumeLink: String,
    val categories: List<String>,  //this
    val contentVersion: String,
    val description: String,    //this
    val imageLinks: ImageLinks,  //this
    val industryIdentifiers: List<IndustryIdentifier>,
    val infoLink: String,
    val language: String,
    val maturityRating: String,
    val pageCount: Long,
    val panelizationSummary: PanelizationSummary,
    val previewLink: String,  //this
    val printType: String,
    val publishedDate: String,
    val publisher: String,
    val ratingsCount: Long,
    val readingModes: ReadingModes,
    val subtitle: String,
    val title: String   //this
)