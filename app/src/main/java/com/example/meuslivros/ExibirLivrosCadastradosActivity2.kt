package com.example.meuslivros

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.meuslivros.database.LivrosDataBase
import com.example.meuslivros.databinding.ActivityExibirLivrosCadastrados2Binding

class ExibirLivrosCadastradosActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityExibirLivrosCadastrados2Binding
    var i :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExibirLivrosCadastrados2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Room.databaseBuilder(
            applicationContext,
            LivrosDataBase::class.java,
            "bancoDeDados.sqlite"
        ).fallbackToDestructiveMigration()

            .allowMainThreadQueries().build()
        binding.textTitulo.text=db.LivrosDao().getAll().get(i).titulo
        binding.textAutor.text=db.LivrosDao().getAll().get(i).autor
        binding.textAno.text=db.LivrosDao().getAll().get(i).ano.toString()
        binding.textNota.text=db.LivrosDao().getAll().get(i).nota

        binding.buttonProximo.setOnClickListener {
            var tamanho = Integer.parseInt(db.LivrosDao().getAll().size.toString())
            if (i < tamanho - 1) {
                binding.textTitulo.text = db.LivrosDao().getAll().get(i + 1).titulo
                binding.textAutor.text = db.LivrosDao().getAll().get(i + 1).autor
                binding.textAno.text = db.LivrosDao().getAll().get(i + 1).ano.toString()
                binding.textNota.text = db.LivrosDao().getAll().get(i + 1).nota
                i++;
            } else {
                Toast.makeText(this, "Limite da lsita de livros alcançado.", Toast.LENGTH_SHORT)
                    .show()

            }
        }
        binding.buttonAnterior .setOnClickListener {
            if(i>1){
                binding.textTitulo.text=db.LivrosDao().getAll().get(i-1).titulo
                binding.textAutor.text=db.LivrosDao().getAll().get(i-1).autor
                binding.textAno.text=db.LivrosDao().getAll().get(i-1).ano.toString()
                binding.textNota.text=db.LivrosDao().getAll().get(i-1).nota
                i--;
            }else{
                Toast.makeText(this, "Inicio da lista alcançado.", Toast.LENGTH_SHORT).show()

            }
        }
    }
}