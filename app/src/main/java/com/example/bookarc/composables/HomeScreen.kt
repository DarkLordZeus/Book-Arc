package com.example.bookarc.composables

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.bookarc.Screen
import com.example.bookarc.components.Mainstate
import com.example.bookarc.components.RetrofitViewModel
import com.example.bookarc.components.SearchWidget
import com.example.bookarc.components.TopBar


@Composable
fun HomeScreen(navController: NavController, resultt: RetrofitViewModel, result1: Mainstate) {

    Column() {

        TopBar(title = "Explore thousands of books in a go")
        SearchWidget(resultt)
        if (result1.isLoading) {
            //
        } else if (result1.data.isNotEmpty()) {

            LazyColumn() {
                items(items = result1.data) { ok ->
//                    val imgurl=
//                    if(ok.volumeInfo.imageLinks!=null){
//                        URLEncoder.encode(ok.volumeInfo.imageLinks.thumbnail, StandardCharsets.UTF_8.toString())
//
//                    }
//
//                    else
//                        URLEncoder.encode("https://www.lifewire.com/thmb/MZ2Q3T4dcb6qD1A2pVS1EtKDLCU=/1200x800/filters:fill(auto,1)/alert-icon-5807a14f5f9b5805c2aa679c.PNG", StandardCharsets.UTF_8.toString())

                    var author:String
                    if(ok.volumeInfo.authors!=null)
                        author=ok.volumeInfo.authors[0]
                    else author="Unknown"

                    var category = if(ok.volumeInfo.categories.isNullOrEmpty())
                        "Notfound"
                    else
                        ok.volumeInfo.categories[0]

                    Box(modifier = Modifier.background(Color.Transparent)
                        .clickable {
                            navController.navigate(route=Screen.Detail.passitem(ok.volumeInfo.title,
                                author,
                                ok.volumeInfo.averageRating
                                ,category
                                ,ok.volumeInfo.description))
                            Log.d("FUCK","${ok.volumeInfo.imageLinks.thumbnail.toString()}")
                        }) {
                        Itemview(item = ok)
                    }


                }
            }
        } else if (result1.error.isNotBlank()) {
            //Toast.makeText(this@MainActivity, "${result.error}", Toast.LENGTH_SHORT).show()}
        }
    }
}