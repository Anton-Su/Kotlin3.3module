package com.example.kotlin33.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kotlin33.presentation.ui.screen.DetailScreen
import com.example.kotlin33.presentation.ui.screen.ListScreen
import com.example.kotlin33.presentation.viewModel.TodoViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

sealed class Screen(val route: String) {
    data object TodoListScreen : Screen("todo_list")
    data object TodoDetailScreen : Screen("todo_detail/{itemId}") {
        fun createRoute(itemId: Int) = "todo_detail/$itemId"
    }
}

@Composable
fun Navigation(navController: NavHostController = rememberNavController(), viewModel: TodoViewModel = viewModel()) {
    NavHost(navController, startDestination = Screen.TodoListScreen.route) {
        composable(Screen.TodoListScreen.route) {
            ListScreen(navHostController = navController, viewModel = viewModel)
        }
        composable(
            Screen.TodoDetailScreen.route,
            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getInt("itemId")
            // Find the item in the ViewModel's list (collectAsState() сомнительно, но по-другому не достать)
            val item = viewModel.todos.collectAsState().value.find { it.id == itemId }
            if (item != null) {
                DetailScreen(navHostController = navController, item = item)
            }
        }
    }
}