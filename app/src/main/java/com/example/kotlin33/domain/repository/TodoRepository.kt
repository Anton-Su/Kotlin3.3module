package com.example.kotlin33.domain.repository

import com.example.kotlin33.domain.model.TodoItem

interface TodoRepository {
    suspend fun getTodos(): List<TodoItem>
    suspend fun toggleTodo(id: Int): TodoItem?
}