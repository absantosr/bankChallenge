package com.santos.bankchallengue.presentation.util

import com.santos.bankchallengue.data.model.TaskEntity

sealed class TaskState {
    object Loading : TaskState()

    data class Success(val data: List<TaskEntity>) : TaskState()
    data class Error(val error: TaskFailure) : TaskState()
}