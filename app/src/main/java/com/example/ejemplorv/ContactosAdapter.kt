package com.example.ejemplorv

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplorv.databinding.ItemContactoBinding

class ContactosAdapter (private val contatos: List<Contacto>, private val contactoPulsadoListener: ContactoPulsadoListener): RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {
    class ViewHolder(private val bindingItemContactos: ItemContactoBinding):RecyclerView.ViewHolder(bindingItemContactos.root){
        fun bind (contacto:Contacto){
            var iniciales: String = ""
            val separador: List<String> = contacto.nombre.split(" ")
            for (nombre: String in separador){
                iniciales += nombre[0]
            }

            bindingItemContactos.textViewNombre.text = iniciales
            bindingItemContactos.textViewContacto.text = contacto.tfno

            if (contacto.genero.equals("Mujer")){
                bindingItemContactos.iconPerson.setImageResource(R.drawable.iconmujer)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemContactoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contatos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contatos[position])
        holder.itemView.setOnClickListener{
            contactoPulsadoListener.contactoPulsado(contatos[position])
        }
    }

}