package com.santos.bankchallengue.data.repository

import com.google.firebase.firestore.CollectionReference
import com.santos.bankchallengue.data.model.TaskEntity
import com.santos.bankchallengue.presentation.util.ResultType
import com.santos.bankchallengue.presentation.util.TaskFailure

interface TaskRepository {

    /*suspend fun getTasks(
        userId: String
    ): ResultType<List<TaskEntity>, TaskFailure>*/

    fun getTasks1(
        userId: String
    ): CollectionReference


    /*suspend fun addTask(
        userId: String,
        tasks: List<TaskEntity>
    ) : ResultType<String>*/
}