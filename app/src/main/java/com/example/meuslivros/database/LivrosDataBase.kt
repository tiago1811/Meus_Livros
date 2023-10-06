package com.example.meuslivros.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.meuslivros.model.Livros
import com.example.meuslivros.repository.LivrosDao

@Database(entities = [Livros::class], version = 2)
abstract class LivrosDataBase: RoomDatabase() {
    abstract fun LivrosDao(): LivrosDao
}