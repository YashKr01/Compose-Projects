package com.example.composeplayground.ui.theme.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeplayground.data.models.TodoTask
import com.example.composeplayground.data.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: ToDoRepository,
) : ViewModel() {

    private val _allTasks =
        MutableStateFlow<List<TodoTask>>(emptyList())
    val allTasks: StateFlow<List<TodoTask>> get() = _allTasks

    fun getAllTasks() = viewModelScope.launch {
        repository.getAllTasks.collectLatest {
            _allTasks.value = it
        }
    }

}