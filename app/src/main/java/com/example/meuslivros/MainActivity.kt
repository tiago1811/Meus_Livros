package com.example.meuslivros

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meuslivros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCadastrar.setOnClickListener{
            var intent = Intent(this, CadastrarLivrosActivity::class.java)
            startActivity(intent)
        }
        binding.btnExibir.setOnClickListener {
            var intent = Intent(this, ExibirLivrosCadastradosActivity2::class.java)
            startActivity(intent) }
    }
}