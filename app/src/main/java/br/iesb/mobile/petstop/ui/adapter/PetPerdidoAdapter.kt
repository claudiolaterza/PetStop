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
import android.util.Log
import br.iesb.mobile.petstop.domain.PetPerdido
import kotlinx.android.synthetic.main.petperdtv.view.*

class PetPerdidoAdapter (var listapetperdido: List<PetPerdido>):RecyclerView.Adapter<PetPerdidoAdapter.PetPerdidoViewHolder>(){
    class PetPerdidoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nome: TextView = itemView.tv_listpetperdido_nome
        val local: TextView = itemView.tv_listpetperdido_local
        val descricao: TextView = itemView.tv_listpetperdido_descricao

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetPerdidoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.petperdtv, parent, false)

        return PetPerdidoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listapetperdido.size
    }

    override fun onBindViewHolder(holder:PetPerdidoViewHolder, position: Int) {
        val petperdido = listapetperdido[position]

        holder.nome.text = petperdido.name
        holder.local.text = petperdido.local
        holder.descricao.text = petperdido.descricao

    }
}