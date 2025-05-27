package com.example.introkotlin_901.Diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin_901.R
import com.example.introkotlin_901.ejemplo1.SumaActivity

class inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)

        val btnCapturar= findViewById<Button>(R.id.btnCapturar)
        btnCapturar.setOnClickListener { btnCapturar() }

        val btnnumer2 = findViewById<Button>(R.id.btnnumer2)
        btnnumer2.setOnClickListener { btnnumer2() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    private fun btnCapturar() {
        val intent = Intent(this, Capturar_Palabras::class.java)
        startActivity(intent)
    }



    private fun btnnumer2() {
        val intent = Intent(this, Buscar_Palabras::class.java)
        startActivity(intent)
    }
}