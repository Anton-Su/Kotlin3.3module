package com.example.kotlin33

import android.app.Application
import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import androidx.test.core.app.ApplicationProvider
import com.example.kotlin33.data.model.TodoJsonDataSource
import com.example.kotlin33.data.repository.TodoRepositoryImpl
import com.example.kotlin33.domain.repository.TodoRepository
import com.example.kotlin33.presentation.theme.Kotlin33Theme
import com.example.kotlin33.presentation.ui.screen.ListScreen
import com.example.kotlin33.presentation.viewModel.TodoViewModel
import org.junit.Rule
import org.junit.Test


class ToDoList {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val context = ApplicationProvider.getApplicationContext<Application>()


    @Test
    fun displaySevenTodosFromJson() {
        composeTestRule.setContent {
            Kotlin33Theme () {
//                val repository = TodoRepositoryImpl(TodoJsonDataSource(context))
                val viewModel = TodoViewModel(context)
                ListScreen(rememberNavController(), viewModel)
            }
        }
    }
}