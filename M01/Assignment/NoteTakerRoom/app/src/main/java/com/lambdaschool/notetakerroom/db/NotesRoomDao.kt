package com.lambdaschool.notetakerroom.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lambdaschool.notetakerroom.model.Note

@Dao
interface NotesRoomDao {

    @Insert
    fun createNote(note: Note): Long

    @Query("SELECT * FROM note")
    fun getNotes(): List<Note>

}