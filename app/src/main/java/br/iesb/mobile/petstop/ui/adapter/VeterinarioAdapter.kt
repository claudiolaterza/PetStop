package br.iesb.mobile.petstop.ui.adapter

import android.content.Context
import android.content.ContentValues
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.domain.Veterinario
import android.util.Log
import kotlinx.android.synthetic.main.veterinario_item.view.*
import kotlinx.android.synthetic.main.vets.view.*

class VeterinarioAdapter (var listaveterinario: List<Veterinario>):RecyclerView.Adapter<VeterinarioAdapter.VeterinarioViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VeterinarioViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.veterinario_item
                , parent, false)

        return VeterinarioViewHolder(view)
    }

    class VeterinarioViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val telefone: TextView = itemView.tv_telefone_veterinario_actv
        val nome: TextView = itemView.tv_nome_veterinario_actv
        val endereco: TextView = itemView.tv_pet_veterinario_actv
        val domicilio: TextView = itemView.tv_domicilio_veterinario_actv

    }


    override fun getItemCount(): Int {
        return listaveterinario.size
    }

    override fun onBindViewHolder(holder: VeterinarioViewHolder, position: Int) {
        val veterinario = listaveterinario[position]

        holder.nome.text = veterinario.name
        holder.endereco.text = veterinario.endereco
        holder.telefone.text = veterinario.telefone.toString()
        holder.domicilio.text = veterinario.domicilio

    }

}

