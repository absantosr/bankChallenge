package com.santos.bankchallengue.data.repository

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.santos.bankchallengue.data.model.TaskEntity
import com.santos.bankchallengue.presentation.util.ResultType
import com.santos.bankchallengue.presentation.util.TaskFailure
import kotlinx.coroutines.tasks.await

class TaskRepositoryImpl(private val firebaseFirestore: FirebaseFirestore) : TaskRepository {
/*
    override suspend fun getTasks(userId: String): ResultType<List<TaskEntity>, TaskFailure> {
        try {
            val resultTask =
                firebaseFirestore.collection("users").document(userId).collection("task").get()
                    .await()
            val tasks = resultTask.toObjects(TaskEntity::class.java)
            return ResultType.Success(tasks)
        } catch (e: Exception) {

        }
    }*/

    override fun getTasks1(userId: String):CollectionReference {
        return firebaseFirestore.collection("users").document(userId).collection("tasks")
    }
}