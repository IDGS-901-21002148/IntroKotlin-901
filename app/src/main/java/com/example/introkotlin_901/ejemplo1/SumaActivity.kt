package com.example.introkotlin_901.ejemplo1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin_901.R

class SumaActivity : AppCompatActivity() {
    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tvResultado: TextView
    private lateinit var radioGroupOperaciones: RadioGroup
    private lateinit var btnSuma: RadioButton
    private lateinit var btnResta: RadioButton
    private lateinit var btnMultiplicacion: RadioButton
    private lateinit var btnDivision: RadioButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_suma)

        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        tvResultado = findViewById(R.id.tvResultado)
        radioGroupOperaciones = findViewById(R.id.radioGroupOperaciones)
        btnSuma = findViewById(R.id.btnSuma)
        btnResta = findViewById(R.id.btnResta)
        btnMultiplicacion = findViewById(R.id.btnMultiplicacion)
        btnDivision = findViewById(R.id.btnDivision)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcular(view: View) {
        // Validar que los campos no estén vacíos
        if (et1.text.toString().trim().isEmpty() || et2.text.toString().trim().isEmpty()) {
            Toast.makeText(this, "Por favor ingrese ambos números", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val num1 = et1.text.toString().toDouble()
            val num2 = et2.text.toString().toDouble()
            var resultado = 0.0


            when (radioGroupOperaciones.checkedRadioButtonId) {
                R.id.btnSuma -> {
                    resultado = num1 + num2
                    Toast.makeText(this, "suma", Toast.LENGTH_SHORT).show()
                }
                R.id.btnResta -> {
                    resultado = num1 - num2
                    Toast.makeText(this, "resta", Toast.LENGTH_SHORT).show()
                }
                R.id.btnMultiplicacion -> {
                    resultado = num1 * num2
                    Toast.makeText(this, "multiplicación", Toast.LENGTH_SHORT).show()
                }
                R.id.btnDivision -> {
                    if (num2 == 0.0) {
                        Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show()
                        return
                    }
                    resultado = num1 / num2
                    Toast.makeText(this, "división", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Seleccione una operación", Toast.LENGTH_SHORT).show()
                    return
                }
            }


            tvResultado.text = "Resultado: ${"%.2f".format(resultado)}"

        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Ingrese números válidos", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}