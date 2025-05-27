package com.example.introkotlin_901.Diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin_901.R
import java.io.FileNotFoundException
import java.io.IOException

class Buscar_Palabras : AppCompatActivity() {

    private val fileName = "diccionario.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar_palabras)

        val btnEspañol = findViewById<RadioButton>(R.id.btnEspañol)
        val btnIngles = findViewById<RadioButton>(R.id.btnIngles)
        val txtPalabraBuscar = findViewById<EditText>(R.id.txtPalabraBuscar)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)
        val txtResultado = findViewById<EditText>(R.id.txtResultadio)

        val btnMenu2 = findViewById<Button>(R.id.btnMenu2)
        btnMenu2.setOnClickListener { btnMenu2() }


        btnEspañol.isChecked = true

        btnBuscar.setOnClickListener {
            val searchWord = txtPalabraBuscar.text.toString().trim()

            if (searchWord.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa la palabra a buscar", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var found = false
            var result = "Palabra no encontrada"

            try {
                openFileInput(fileName).bufferedReader().useLines { lines ->
                    for (line in lines) {
                        val parts = line.split(',')
                        if (parts.size == 2) {
                            val espanol = parts[0].trim()
                            val ingles = parts[1].trim()

                            if (btnEspañol.isChecked) {

                                if (espanol.equals(searchWord, ignoreCase = true)) {
                                    result = ingles
                                    found = true
                                    break
                                }
                            } else if (btnIngles.isChecked) {

                                if (ingles.equals(searchWord, ignoreCase = true)) {
                                    result = espanol
                                    found = true
                                    break
                                }
                            }
                        }
                    }
                }
            } catch (e: FileNotFoundException) {
                Toast.makeText(this, "El archivo de diccionario no existe.", Toast.LENGTH_LONG).show()
                result = "Archivo no encontrado"
            } catch (e: IOException) {
                e.printStackTrace()
                Toast.makeText(this, "Error al leer el archivo: ${e.message}", Toast.LENGTH_LONG).show()
                result = "Error de lectura"
            }

            txtResultado.setText(result)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun btnMenu2() {
        val intent = Intent(this, inicio::class.java)
        startActivity(intent)
    }
}