package com.example.introkotlin_901.Diccionario

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast // Import Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin_901.R
import java.io.IOException // Import IOException

class Capturar_Palabras : AppCompatActivity() {

    private val fileName = "diccionario.txt"

    @SuppressLint("WrongViewCast", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capturar_palabras)

        val PalabraEspañol = findViewById<EditText>(R.id.nuevaEspañol)
        val PalabraIngles = findViewById<EditText>(R.id.nuevaIngles)
        val BotonGuardar = findViewById<Button>(R.id.btnGuardar)
        val Mensaje = findViewById<EditText>(R.id.txtGuardado)

        val btnMenu1= findViewById<Button>(R.id.btnMenu1)
        btnMenu1.setOnClickListener { btnMenu1() }


        BotonGuardar.setOnClickListener {
            val espanol = PalabraEspañol.text.toString().trim()
            val ingles = PalabraIngles.text.toString().trim()

            if (espanol.isNotEmpty() && ingles.isNotEmpty()) {
                val palabraPar = "$espanol,$ingles\n"

                try {

                    openFileOutput(fileName, MODE_APPEND).use {
                        it.write(palabraPar.toByteArray())
                    }
                    PalabraEspañol.text.clear()
                    PalabraIngles.text.clear()
                    Toast.makeText(this, "Palabra almacenadas correctamente", Toast.LENGTH_SHORT).show()
                    Mensaje.setText("Palabra guardada")
                } catch (e: IOException) {
                    e.printStackTrace()
                    Toast.makeText(this, "Error al guardar las palabras: ${e.message}", Toast.LENGTH_LONG).show()
                    Mensaje.setText("Error al guardar")
                }
            } else {
                Toast.makeText(this, "Por favor, ingresa ambas palabras", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun btnMenu1() {
        val intent = Intent(this, inicio::class.java)
        startActivity(intent)
    }
}