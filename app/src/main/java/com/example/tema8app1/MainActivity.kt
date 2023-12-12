package com.example.tema8app1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tema8app1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtenemos la referencia a la colección de preferencias
        val sharedPreferences = getSharedPreferences("MiPreferencia", Context.MODE_PRIVATE)

        // Declaramos el evento onClick en el botón de guardar el correo,
        // de forma que salvamos los datos
        binding.btnGuardar.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString("email", binding.edtCorreo.text.toString())  // Puedes usar putInt, putBoolean, etc., según el tipo de dato
            editor.apply()
        }

        // Declaramos el evento onClick en el botón de cargar el correo
        // de las preferencias
        binding.btnRecuperar.setOnClickListener {
            val valorRecuperado = sharedPreferences.getString("email", "Sin valor")
            binding.tvValorGuardado.text = valorRecuperado

        }

    }
}