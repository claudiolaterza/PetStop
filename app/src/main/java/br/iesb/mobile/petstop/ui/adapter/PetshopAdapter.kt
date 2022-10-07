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
import br.iesb.mobile.petstop.domain.Petshop
import android.util.Log
import kotlinx.android.synthetic.main.petshop_item.view.*
import kotlinx.android.synthetic.main.petshops.view.*

class PetshopAdapter (var petshops: List<Petshop>):RecyclerView.Adapter<PetshopAdapter.PetshopViewHolder>(){
    class PetshopViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nome: TextView = itemView.tv_nome_petshop_actv;
        val endereco: TextView = itemView.tv_end_petshop_actv;
        val telefone: TextView = itemView.tv_lat_petshop_actv;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetshopViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.petshop_item, parent, false)
        return PetshopViewHolder(view)
    }

    override fun getItemCount(): Int {
        return petshops.size
    }

    override fun onBindViewHolder(holder: PetshopViewHolder, position: Int) {
        val petshop = petshops[position]
        holder.nome.text = petshop.name
        holder.endereco.text = petshop.endereco
        holder.telefone.text = petshop.telefone.toString()

    }

}

