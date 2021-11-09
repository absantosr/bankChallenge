package com.santos.bankchallengue.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.santos.bankchallengue.data.model.TaskEntity
import com.santos.bankchallengue.data.repository.TaskRepositoryImpl
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {

    private val taskRepository = TaskRepositoryImpl(FirebaseFirestore.getInstance())

    private val _tasksLiveData = MutableLiveData<List<TaskEntity>>()
    val tasksLiveData: LiveData<List<TaskEntity>> get() = _tasksLiveData

    fun getTask(userId: String) {
        viewModelScope.launch {
            taskRepository.getTasks1(userId).addSnapshotListener { snapshot, exception ->
                snapshot?.let {
                    val tasks = snapshot.toObjects(TaskEntity::class.java)
                    _tasksLiveData.value = tasks
                }
            }
        }
    }
}