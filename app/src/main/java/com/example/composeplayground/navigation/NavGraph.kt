package com.example.composeplayground.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composeplayground.presentation.screens.welcome.WelcomeScreen
import com.example.composeplayground.presentation.screens.home.HomeScreen
import com.example.composeplayground.presentation.screens.search.SearchScreen
import com.example.composeplayground.presentation.screens.splash.SplashScreen
import com.example.composeplayground.utils.Constants
import com.google.accompanist.pager.ExperimentalPagerApi

@Composable
@ExperimentalPagerApi
@ExperimentalAnimationApi
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) { SplashScreen(navController = navController) }
        composable(route = Screen.Welcome.route) { WelcomeScreen(navHostController = navController) }
        composable(route = Screen.Home.route) { HomeScreen(navController = navController) }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(Constants.DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) { }
        composable(route = Screen.Search.route) { SearchScreen(navController = navController) }
    }
}