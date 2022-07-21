package com.example.composeplayground.navigation

import androidx.navigation.NavController
import com.example.composeplayground.data.utils.Action
import com.example.composeplayground.data.utils.Constants

class Screens(navController: NavController) {

    val list: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(Constants.LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = { taskId ->
        navController.navigate("task/${taskId}")
    }

}