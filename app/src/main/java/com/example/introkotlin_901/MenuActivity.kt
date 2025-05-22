package com.example.introkotlin_901

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin_901.Cinepolis.Cinepolis
import com.example.introkotlin_901.ejemplo1.SumaActivity
import com.example.introkotlin_901.ejemplo2.Saludo

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val Ejemplo1 = findViewById<Button>(R.id.btn1)
        Ejemplo1.setOnClickListener { navegateToSaludo() }

        val btnCine = findViewById<Button>(R.id.btn2)
        btnCine.setOnClickListener { Cine() }

        val btnSaludo = findViewById<Button>(R.id.btn3)
        btnSaludo.setOnClickListener { Saludos() }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navegateToSaludo() {
        val intent = Intent(this, SumaActivity::class.java)
        startActivity(intent)
    }

    private fun Cine() {
        val intent = Intent(this, Cinepolis::class.java)
        startActivity(intent)
    }


    private fun Saludos() {
        val intent = Intent(this, Saludo::class.java)
        startActivity(intent)
    }

}