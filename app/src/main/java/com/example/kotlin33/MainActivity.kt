package com.example.kotlin33

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlin33.data.local.TodoJsonDataSource
import com.example.kotlin33.data.repository.TodoRepositoryImpl
import com.example.kotlin33.domain.usecase.GetAllTodosUseCase
import com.example.kotlin33.domain.usecase.GetTodoUseCase
import com.example.kotlin33.presentation.navigation.Navigation
import com.example.kotlin33.presentation.theme.Kotlin33Theme
import com.example.kotlin33.presentation.viewModel.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val jsonDataSource = TodoJsonDataSource(this)
        val repository = TodoRepositoryImpl(jsonDataSource)
        val getTodosUseCase = GetAllTodosUseCase(repository)
        val toggleTodoUseCase = GetTodoUseCase(repository)
        val viewModel = TodoViewModel(getTodosUseCase, toggleTodoUseCase)
        setContent {
            Kotlin33Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    Navigation(viewModel=viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Kotlin33Theme {
        Greeting("Android")
    }
}