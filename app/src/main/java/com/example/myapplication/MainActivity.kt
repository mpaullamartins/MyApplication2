package com.example.esportesrecife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.esportesrecife.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference




class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener {entrar()}

        val firebase : DatabaseReference = firebaseDatabase.getInstance().getReference()
    }

    private fun entrar() {
        val nome = binding.user.text.toString()

        val intent = Intent(this, SegundaActivity::class.java).also {
            it.putExtra("nome", nome)
            startActivity(it)
        }

        val database = Firebase.database
        val myRef = database.getReference("teste")

        myRef.setValue("Hello, World!")

    }
}