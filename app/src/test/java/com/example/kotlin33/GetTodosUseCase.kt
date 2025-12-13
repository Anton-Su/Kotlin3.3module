package com.example.kotlin33

import com.example.kotlin33.domain.model.TodoItem
import com.example.kotlin33.domain.repository.TodoRepository
import com.example.kotlin33.domain.usecase.GetAllTodosUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class FakeTodoRepository : TodoRepository {
    private val todos = mutableListOf(
        TodoItem(1, "Task 1", "Description 1", false),
        TodoItem(2, "Task 2", "Description 2", true),
        TodoItem(3, "Task 3", "Description 3", false)
    )

    override suspend fun getTodos(): List<TodoItem> = todos

    override suspend fun toggleTodo(id: Int): Unit {
        val index = todos.indexOfFirst { it.id == id }
        if (index != -1) {
            val todo = todos[index]
            val updated = todo.copy(isCompleted = !todo.isCompleted)
            todos[index] = updated
        }
    }
}


class GetTodosUseCaseTest {
    private lateinit var getTodosUseCase: GetAllTodosUseCase
    private lateinit var repository: TodoRepository
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        repository = FakeTodoRepository()
        getTodosUseCase = GetAllTodosUseCase(repository)
    }

    @Test
    fun `GetTodosUseCase returns 3 tasks`() = runTest(testDispatcher) {
        val todos = getTodosUseCase()
        assertEquals(3, todos.size)
    }

    @Test
    fun `toggleTodo changes isCompleted`() = runTest(testDispatcher) {
        val todoBefore = repository.getTodos().first { it.id == 1 }
        assertEquals(false, todoBefore.isCompleted)
        repository.toggleTodo(1)
        val todoAfter = repository.getTodos().first { it.id == 1 }
        assertEquals(true, todoAfter.isCompleted)
    }
}