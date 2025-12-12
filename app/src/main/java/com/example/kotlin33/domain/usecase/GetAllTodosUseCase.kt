package com.example.kotlin33.domain.usecase

import com.example.kotlin33.domain.model.TodoItem
import com.example.kotlin33.domain.repository.TodoRepository

class GetAllTodosUseCase(private val repository: TodoRepository) {
    suspend operator fun invoke(): List<TodoItem> {
        return repository.getTodos()
    }
}


