package com.example.database

import androidx.lifecycle.LiveData
import com.example.database.room.model.Note

interface DataBaseRepository {

    val readAll: LiveData<List<Note>>

    suspend fun create(note:Note,onSuccess:()->Unit)
    suspend fun delete(note:Note,onSuccess:()->Unit)
    suspend fun update(note:Note,onSuccess:()->Unit)


}