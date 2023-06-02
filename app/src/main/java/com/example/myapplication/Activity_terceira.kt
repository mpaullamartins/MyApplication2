package com.example.myapplication

data class Activity_terceira()

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.esportesrecife.databinding.ActivityTerceiraBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class TerceiraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTerceiraBinding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTerceiraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var edAutor =  binding.editAutor
        var edTitulo = binding.editTituloAlerta
        var edDescricao = binding.editDescricao
        var edDtAlerta = binding.editDataAlerta
        var btPublicar = binding.btnPubliAlerta

        dbRef = FirebaseDatabase.getInstance().getReference("Alertas")

        btPublicar!!.setOnClickListener {
            val empTitulo = edTitulo!!.text.toString()
            val empAutor= edAutor!!.text.toString()
            val empDescricao = edDescricao!!.text.toString()
            val  empDtAlerta = edDtAlerta!!.text.toString()

            if(empTitulo.isEmpty()){
                edTitulo.error = "Por favor insira um título"
            }
            if(empDescricao.isEmpty()){
                edDescricao.error = "Por favor insira uma descrição"
            }
            if(empDtAlerta.isEmpty()){
                edDtAlerta.error = "Por favor insira uma data"
            }
            if(empAutor.isEmpty()){
                edAutor.error = "Por favor insira um nome"
            }

            val empId = dbRef.push().key!!

            val alertas = AlertaModelo(empId, empTitulo, empDescricao, empDtAlerta, empAutor)

            dbRef.child(empId).setValue(alertas)
                .addOnCompleteListener{
                    Toast.makeText(this, "Alerta publicado", Toast.LENGTH_SHORT).show()

                    edTitulo.text.clear()
                    edDescricao.text.clear()
                    edDtAlerta.text.clear()
                    edAutor.text.clear()
                }.addOnFailureListener{ err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
                }
        }
    }
}
