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
                Contacto("Juan Miguel Gomez", "665452423", "Hombre"),
                Contacto("Fernando Jimenez Romero", "665452423", "Hombre"),
                Contacto("Maria Auxiliadora", "665452423", "Mujer"),
                Contacto("Alicia Amante Vega", "665452423", "Mujer"),
                Contacto("Lucia Miguel Gomez", "665452423", "Mujer"),
                Contacto("Manuel Trujano", "665452423", "Hombre"),
                Contacto("Yeray Moreno", "665452423", "Hombre"),
                Contacto("Antonio Jimnez Negrete", "665452423", "Hombre"),
                Contacto("Lucas Monte", "665452423", "Hombre"),
                Contacto("Alejandro Reinoso", "665452423", "Hombre"),
                Contacto("Pablo Guerrero", "665452423", "Hombre"),
                Contacto("Nerea Guttierrez", "665452423", "Mujer"),
                Contacto("Isabel Bejarano", "665452423", "Mujer"),
                Contacto("Carmen Lorence", "665452423", "Mujer"),
                Contacto("Teresa Campos", "665452423", "Mujer"),
                Contacto("Pedro Gallardo", "665452423", "Hombre")

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