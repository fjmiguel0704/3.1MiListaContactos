package com.example.ejemplorv

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejemplorv.databinding.ActivityMainBinding
import com.example.ejemplorv.databinding.ContactosBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contantos = ContactosBinding.inflate(layoutInflater)
        setContentView(contantos.root)
        contantos.vistaContactos.adapter = ContactosAdapter(
            listOf(
                Contacto("Juan", "665452423"),
                Contacto("Juan", "665452423"),
                Contacto("Juan", "665452423"),
                Contacto("Juan", "665452423"),
                Contacto("Juan", "665452423"),
                Contacto("Juan", "665452423"),
                Contacto("Juan", "665452423"),
                Contacto("Juan", "665452423")

            ), object : ContactoPulsadoListener{
                override fun contactoPulsado(contacto: Contacto) {
                    val dial = Intent (
                        Intent.ACTION_DIAL,
                        Uri.parse("tel:"+contacto.tfno)
                    ) // Creamos una llamada al Intent de llamadas
                    startActivity(dial)
                }
            }
        )

    }
}