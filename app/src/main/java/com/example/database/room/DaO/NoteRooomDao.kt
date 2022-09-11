package com.example.database.room.DaO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notes.model.Note

@Dao
interface NoteRooomDao {
    @Query("SELECT * FROM NOTES_TABLE")
    fun getAllNotes(): LiveData<List<Note>>
    @Insert
    suspend fun addNote(note: Note)
    @Update
    suspend fun updateNote(note:Note)
    @Delete
    suspend fun deleteNote(note:Note)
}