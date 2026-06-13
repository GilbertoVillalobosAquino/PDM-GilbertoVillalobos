package com.example.laboratorio04_gjva.data

import com.example.laboratorio04_gjva.model.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class TaskRepository(private val taskDao: TaskDao) {
    val allTasks: Flow<List<Task>> = taskDao.getAllTasks()

    suspend fun insert(task: Task) = withContext(Dispatchers.IO) {
        taskDao.insertTask(task)
    }

    suspend fun update(task: Task) = withContext(Dispatchers.IO) {
        taskDao.updateTask(task)
    }

    suspend fun delete(task: Task) = withContext(Dispatchers.IO) {
        taskDao.deleteTask(task)
    }
}