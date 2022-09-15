package com.example.bookarc

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.bookarc.components.Mainstate
import com.example.bookarc.components.RetrofitViewModel
import com.example.bookarc.composables.AnimatedSplashScreen
import com.example.bookarc.composables.DetailScreen
import com.example.bookarc.composables.HomeScreen

@Composable
fun SetupNavGraph(navController: NavHostController, result: RetrofitViewModel, result1: Mainstate) {
    NavHost(navController = navController, startDestination = Screen.Splash.route){
        composable(
            route = Screen.Splash.route
        ){
            AnimatedSplashScreen(navController = navController)
        }
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController = navController, resultt = result,result1)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(

                navArgument(title){
                    type= NavType.StringType
                },
                navArgument(author){
                    type= NavType.StringType
                },
                navArgument(ratingarg){
                    type= NavType.FloatType
                },
                navArgument(category){
                    type= NavType.StringType
                },
                navArgument(decription){
                    type= NavType.StringType
                }
            )
        ){
            DetailScreen(navController = navController, titlee = it.arguments?.getString(title), author = it.arguments?.getString(
                author), rating = it.arguments?.getFloat(
                ratingarg), category = it.arguments?.getString(category), decription = it.arguments?.getString(
                decription))
        }
    }
}