package com.example.meuslivros.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "livros")
data class Livros(

    @ColumnInfo(name = "titulos") val titulo: String,
    @ColumnInfo(name = "autores") val autor: String,
    @ColumnInfo(name = "anos") val ano: Int,
    @ColumnInfo(name = "notas") val nota: String ) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}