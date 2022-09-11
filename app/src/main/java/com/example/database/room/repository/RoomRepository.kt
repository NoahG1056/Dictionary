package com.example.database.room.repository

import androidx.lifecycle.LiveData
import com.example.database.DataBaseRepository
import com.example.database.room.DaO.NoteRooomDao
import com.example.notes.model.Note

class RoomRepository(private val noteRoomDao:NoteRooomDao) :DataBaseRepository{
    override val readAll: LiveData<List<Note>>
        get() = noteRoomDao.getAllNotes()

    override suspend fun create(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.addNote(note=note)
    }

    override suspend fun delete(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.deleteNote(note=note)
    }

    override suspend fun update(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.updateNote(note = note)
    }
}