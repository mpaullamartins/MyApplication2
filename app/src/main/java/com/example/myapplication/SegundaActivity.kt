package com.example.myapplication

data class SegundaActivity()

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.esportesrecife.databinding.ActivitySegundaBinding

class SegundaActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySegundaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recuperaDados()

        binding.btnProximo.setOnClickListener { prosseguir() }

        binding.btnConsultarAlertas.setOnClickListener{ verAlertas() }
    }

    private fun recuperaDados() {
        val nome = intent.getStringExtra("nome")

        binding.user.setText(nome)
    }

    private fun prosseguir() {

        val intent = Intent(this, TerceiraActivity::class.java)

        startActivity(intent)
    }

    private fun verAlertas() {
        val intent2 = Intent(this, ListaAlertasActivity::class.java)

        startActivity(intent2)
    }
}
