package com.gutierrez.eddy.practica_calificada02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.gutierrez.eddy.practica_calificada02.databinding.ActivityDetailBinding
import com.gutierrez.eddy.practica_calificada02.databinding.ActivityEjercicio02Binding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let{
            showData(it)
        }
        listeningComponentUi()
    }
    private fun showData(paramExtras: Bundle){

        val nombreClient = paramExtras.getString((NOMBRE_CLIENT_KEY))
        val numberClient = paramExtras.getString(NUMBER_KEY)
        val product = paramExtras.getString(PRODUCT_KEY)
        val ciudad = paramExtras.getString(CIUDAD_KEY)
        val direccion = paramExtras.getString(DIRECCION_KEY)

        binding.tvNombreCliente.text = nombreClient
        binding.tvNumeroCliente.text = numberClient
        binding.tvProducto.text = product
        binding.tvUbicacion.text = ciudad
        binding.tvDireccion.text = direccion

    }
    private fun listeningComponentUi(){
        binding.btnPhone.setOnClickListener(){
            phone()
        }
        binding.btnWts.setOnClickListener(){
            wspMessage()
        }
        binding.btnUbi.setOnClickListener(){
            maps()
        }
    }

    private fun phone(){
        val phone = binding.tvNumeroCliente.text.toString()
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:+51$phone")
        startActivity(intent)
    }


    private fun maps() {
        val address = binding.tvDireccion.text.toString()
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("geo:0,0?q=$address")
        startActivity(intent)
    }

    private fun wspMessage() {
        val nombreCliente = binding.tvNombreCliente.text.toString()
        val productos = binding.tvProducto.text.toString()
        val direccion = binding.tvDireccion.text.toString()

        val message = "Hola $nombreCliente, tus productos: $productos están en camino a la dirección: $direccion"

        val phone = binding.tvNumeroCliente.text.toString()
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$phone&text=${Uri.encode(message)}")
        startActivity(intent)
    }


}