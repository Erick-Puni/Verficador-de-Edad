package com.example.verificadordeedad

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.principal)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Variables de GUI
        val etEdad: EditText = findViewById(R.id.etEdad)
        val btnVerificarEdad: Button = findViewById(R.id.btnVerificarEdad)
        val tvResultado: TextView = findViewById(R.id.tvResultado)

        // Acción del boton
        btnVerificarEdad.setOnClickListener {

            //Extraer el texto ingresado
            val textoEdad = etEdad.text.toString()

            //  Validar que no este en vacio
            if (textoEdad.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa tu edad", Toast.LENGTH_SHORT).show()
            } else {
                // Convertir el texto a un número
                val edad = textoEdad.toIntOrNull()

                if (edad == null) {
                    // Si no es un número válido, mostrar un error
                    Toast.makeText(this, "Ingresa un número válido", Toast.LENGTH_SHORT).show()
                } else {
                    // Verificar si es mayor o menor de edad

                    if (edad >= 18) {
                        tvResultado.text = "Eres mayor de edad 🎉"
                        tvResultado.setTextColor(getColor(R.color.green)) // Cambiar color a verde
                    } else {
                        tvResultado.text = "Eres menor de edad 🚫"
                        tvResultado.setTextColor(getColor(R.color.red)) // Cambiar color a rojo
                    }
                }
            }
        }
    }
}
