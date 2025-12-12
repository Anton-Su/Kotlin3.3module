package com.example.kotlin33.data.repository

import com.example.kotlin33.data.model.TodoJsonDataSource
import com.example.kotlin33.domain.model.TodoItem
import com.example.kotlin33.domain.repository.TodoRepository


class TodoRepositoryImpl(dataSource: TodoJsonDataSource) : TodoRepository {
    private val todosDto = dataSource.getTodos()

    override suspend fun getTodos(): List<TodoItem> {
        return todosDto.map { it.toDomain() }
    }

    override suspend fun toggleTodo(id: Int): TodoItem? {
        return todosDto.find { it.id == id }?.toDomain()
    }
}