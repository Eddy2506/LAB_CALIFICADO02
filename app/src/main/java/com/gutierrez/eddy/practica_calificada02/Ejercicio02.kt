package com.gutierrez.eddy.practica_calificada02

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.gutierrez.eddy.practica_calificada02.databinding.ActivityEjercicio02Binding

class Ejercicio02 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Establecer el click listener para el botón Registrar
        binding.btnRegistrar.setOnClickListener {
            if (isEmptyInputs()) {
                Toast.makeText(this, "Hay algún campo vacío", Toast.LENGTH_SHORT).show()
            } else {
                // Si no hay campos vacíos, ir a la actividad de detalle
                goDetailActivity()
            }
        }
    }

    private fun goDetailActivity() {
        val nombreClient = binding.editNombreCliente.text.toString()
        val numberClient = binding.editNumeroCliente.text.toString()
        val product = binding.editProductos.text.toString()
        val ciudad = binding.editCiudad.text.toString()
        val direccion = binding.editDireccion.text.toString()

        // Crear un intent y pasar los datos a la actividad de detalle
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(NOMBRE_CLIENT_KEY, nombreClient)
            putExtra(NUMBER_KEY, numberClient)
            putExtra(PRODUCT_KEY, product)
            putExtra(CIUDAD_KEY, ciudad)
            putExtra(DIRECCION_KEY, direccion)
        }

        startActivity(intent)
    }

    // Verificar si los campos de entrada están vacíos
    private fun isEmptyInputs(): Boolean {
        return binding.editNombreCliente.text.isEmpty() ||
                binding.editNumeroCliente.text.isEmpty() ||
                binding.editProductos.text.isEmpty() ||
                binding.editCiudad.text.isEmpty() ||
                binding.editDireccion.text.isEmpty()
    }
}
