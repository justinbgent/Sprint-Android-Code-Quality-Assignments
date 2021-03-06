package com.lambdaschool.notetakerroom.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lambdaschool.notetakerroom.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NotesRoomDB : RoomDatabase() {
    abstract fun notesDao(): NotesRoomDao
}