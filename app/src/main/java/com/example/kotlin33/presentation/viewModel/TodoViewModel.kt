package com.example.kotlin33.presentation.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin33.data.model.TodoJsonDataSource
import com.example.kotlin33.data.repository.TodoRepositoryImpl
import com.example.kotlin33.domain.model.TodoItem
import com.example.kotlin33.domain.usecase.GetAllTodosUseCase
import com.example.kotlin33.domain.usecase.GetTodoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TodoViewModel(application: Application): AndroidViewModel(application) {
    private val dataSource = TodoJsonDataSource(getApplication())
    private val repository = TodoRepositoryImpl(dataSource)
    private val getAllTodosUseCase = GetAllTodosUseCase(repository)
    private val toggleToDoUseCase = GetTodoUseCase(repository)
    private val _todos = MutableStateFlow<List<TodoItem>>(emptyList())
    val todos = _todos.asStateFlow()

    init {
        loadTodos()
    }

    private fun loadTodos() {
        viewModelScope.launch {
            _todos.value = getAllTodosUseCase()
        }
    }

    fun toggleToDo(id: Int) { // Функция переключения чекбокса
        viewModelScope.launch {
            toggleToDoUseCase(id)
            _todos.value = getAllTodosUseCase()
        }

    }

}

