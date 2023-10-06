package com.example.meuslivros.repository

import androidx.room.*;
import com.example.meuslivros.model.Livros;


@Dao
interface LivrosDao {
    @Query("SELECT * FROM livros")
    fun getAll(): Array<Livros>;

    @Insert
    fun inserir(livro:Livros);

    @Update
    fun atualizar(livro:Livros);

    @Delete
    fun removerLivro(livro:Livros);
}