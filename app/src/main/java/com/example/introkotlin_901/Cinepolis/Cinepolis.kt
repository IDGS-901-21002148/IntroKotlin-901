package com.example.introkotlin_901.Cinepolis

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin_901.R

class Cinepolis : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis)

        val nombreEditText = findViewById<EditText>(R.id.txtNombre)
        val compradoresEditText = findViewById<EditText>(R.id.txtCompradores)
        val siRadioButton = findViewById<RadioButton>(R.id.btnSi)
        val noRadioButton = findViewById<RadioButton>(R.id.btnNo)
        val boletosEditText = findViewById<EditText>(R.id.txtBoletos)
        val totalTextView = findViewById<TextView>(R.id.textTotal)
        val calcularButton = findViewById<Button>(R.id.btnTotalC)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        calcularButton.setOnClickListener {
            calcularTotal(
                nombreEditText,
                compradoresEditText,
                siRadioButton,
                boletosEditText,
                totalTextView
            )
        }
    }

    private fun calcularTotal(
        nombreEditText: EditText,
        compradoresEditText: EditText,
        siRadioButton: RadioButton,
        boletosEditText: EditText,
        totalTextView: TextView
    ) {
        try {

            val nombre = nombreEditText.text.toString()
            val numCompradores = compradoresEditText.text.toString().toInt()
            val numBoletos = boletosEditText.text.toString().toInt()
            val tieneTarjetaCineco = siRadioButton.isChecked


            if (nombre.isEmpty()) {
                Toast.makeText(this, "Ingrese el nombre del comprador", Toast.LENGTH_SHORT).show()
                return
            }

            if (numCompradores <= 0) {
                Toast.makeText(this, "Debe haber minimo 1 comprador", Toast.LENGTH_SHORT).show()
                return
            }

            val maxBoletos = numCompradores * 7
            if (numBoletos <= 0) {
                Toast.makeText(this, "Debe comprar al menos 1 boleto", Toast.LENGTH_SHORT).show()
                return
            }

            if (numBoletos > maxBoletos) {
                Toast.makeText(
                    this,
                    "Límite excedido: Máximo $maxBoletos boletos ($numCompradores compradores es de 7 boletos)",
                    Toast.LENGTH_LONG
                ).show()
                return
            }


            val precioUnitario = 12
            var total = numBoletos * precioUnitario.toDouble()


            total = when {
                numBoletos > 5 -> total * 0.85
                numBoletos in 3..5 -> total * 0.90
                else -> total
            }


            if (tieneTarjetaCineco) {
                total *= 0.90
            }


            val mensaje = """
                Comprador: $nombre
                Boletos: $numBoletos (Límite: $maxBoletos)
                Total a pagar: $${"%.2f".format(total)}
                ${if (tieneTarjetaCineco) "Con tarjeta Cineco" else "Sin tarjeta Cineco"}
            """.trimIndent()

            totalTextView.text = mensaje

        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Ingrese valores numéricos válidos", Toast.LENGTH_SHORT).show()
        }
    }
}