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

class VeterinarioAdapter (var listaveterinario: List<Veterinario>, var clickVeterinario: ClickVeterinario):RecyclerView.Adapter<VeterinarioAdapter.VeterinarioViewHolder>(){

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
        val curriculo: TextView = itemView.tv_curriculo_item_veterinario
        val cardView = itemView.card_veterinario

    }

    interface ClickVeterinario{
        fun clickVeterinario(veterinario: Veterinario)
    }

    override fun getItemCount(): Int {
        return listaveterinario.size
    }

    override fun onBindViewHolder(holder: VeterinarioViewHolder, position: Int) {
        val veterinario = listaveterinario[position]

        holder.nome.text = veterinario.name.toString()
        holder.endereco.text = veterinario.endereco.toString()
        holder.telefone.text = veterinario.telefone.toString()
        holder.domicilio.text = veterinario.domicilio.toString()
        holder.curriculo.text = veterinario.curriculo.toString()

        holder.cardView.setOnClickListener{
            clickVeterinario.clickVeterinario(veterinario)
        }
    }
}