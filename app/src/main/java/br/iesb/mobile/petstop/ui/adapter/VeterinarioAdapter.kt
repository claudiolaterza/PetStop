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
import kotlinx.android.synthetic.main.vets.view.*

class VeterinarioAdapter (var listaveterinario: List<Veterinario>):RecyclerView.Adapter<VeterinarioAdapter.VeterinarioViewHolder>(){
    class VeterinarioViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nome: TextView = itemView.tv_listveterinario_nome
        val endereco: TextView = itemView.tv_listveterinario_endereco
        val telefone: TextView = itemView.tv_listveterinario_telefone

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VeterinarioViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.vets, parent, false)

        return VeterinarioViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaveterinario.size
    }

    override fun onBindViewHolder(holder: VeterinarioViewHolder, position: Int) {
        val veterinario = listaveterinario[position]

        holder.nome.text = veterinario.name
        holder.endereco.text = veterinario.endereco
        holder.telefone.text = veterinario.telefone.toString()

    }

}

