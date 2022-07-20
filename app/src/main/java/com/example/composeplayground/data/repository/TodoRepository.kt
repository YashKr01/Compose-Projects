package com.example.composeplayground.data.repository

import com.example.composeplayground.data.models.TodoDao
import com.example.composeplayground.data.models.TodoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class ToDoRepository @Inject constructor(private val toDoDao: TodoDao) {

    val getAllTasks: Flow<List<TodoTask>> = toDoDao.getAllTasks()
    val sortByLowPriority: Flow<List<TodoTask>> = toDoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<TodoTask>> = toDoDao.sortByHighPriority()

    fun getSelectedTask(taskId: Int) = toDoDao.getSelectedTask(taskId = taskId)

    suspend fun addTask(toDoTask: TodoTask) = toDoDao.addTask(toDoTask = toDoTask)

    suspend fun updateTask(toDoTask: TodoTask) = toDoDao.updateTask(toDoTask = toDoTask)

    suspend fun deleteTask(toDoTask: TodoTask) = toDoDao.deleteTask(toDoTask = toDoTask)

    suspend fun deleteAllTasks() = toDoDao.deleteAllTasks()

    fun searchDatabase(searchQuery: String) = toDoDao.searchDatabase(searchQuery = searchQuery)

}