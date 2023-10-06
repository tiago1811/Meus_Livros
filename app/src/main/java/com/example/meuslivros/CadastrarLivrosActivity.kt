package com.example.meuslivros

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.meuslivros.database.LivrosDataBase
import com.example.meuslivros.databinding.ActivityCadastrarLivrosBinding
import com.example.meuslivros.model.Livros

class CadastrarLivrosActivity : AppCompatActivity() {

    lateinit var binding: ActivityCadastrarLivrosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastrarLivrosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Room.databaseBuilder(
            applicationContext,
            LivrosDataBase::class.java,
            "bancoDeDados.sqlite"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()

        binding.buttonCancelar.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.buttonCadastrar.setOnClickListener {

            var titulo = binding.editTitulo.text.toString()
            var autor = binding.editAutor.text.toString()
            var ano = Integer.parseInt(binding.editAno.text.toString())
            var nota = binding.nota.rating.toString()
            val t = Livros(titulo, autor, ano, nota)
            db.LivrosDao().inserir(t)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}