package com.example.composeplayground.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.composeplayground.data.utils.Constants

@Composable
fun setupNavigation(
    navController: NavHostController,
) {

    val screen = remember(navController) {
        Screens(navController)
    }

    NavHost(navController = navController, startDestination = Constants.LIST_SCREEN) {
        listComposable { screen.task }
        taskComposable { screen.list }
    }

}