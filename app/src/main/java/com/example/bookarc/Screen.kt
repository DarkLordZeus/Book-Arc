package com.example.bookarc

const val imgurlarg="img"
const val title="title"
const val author="author"
const val ratingarg="rating"
const val category="category"
const val decription="description"
const val visitlink="visitlink"

sealed class Screen(val route:String){
    object Home:Screen(route = "home_screen")
    object Splash:Screen(route = "splashscreen")
    object Detail:Screen(route = "detail_screen/{$title}/{$author}/{$ratingarg}/{$category}/{$decription}"){
        fun passitem(

            title:String?,
            author:String?,
            rating:Float?,
            category:String?,
            decription:String?


        ):String{
            return "detail_screen/$title/$author/$rating/$category/$decription"
        }
    }
}
