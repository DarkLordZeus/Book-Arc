package com.example.bookarc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bookarc.components.RetrofitViewModel
import com.example.bookarc.ui.theme.BookArcTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var navController:NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val retrofitViewModel:RetrofitViewModel by viewModels()
        retrofitViewModel.gettrendingimage()
        setContent {

            val result = retrofitViewModel.list.value
            BookArcTheme {
                navController= rememberNavController()
                // A surface container using the 'background' color from the theme
                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
                    ) {
                        //HomeScreen(result = result)
                    SetupNavGraph(navController = navController,retrofitViewModel,result)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BookArcTheme {

    }
}