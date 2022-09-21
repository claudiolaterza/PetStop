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
import br.iesb.mobile.petstop.domain.Encontro
import kotlinx.android.synthetic.main.enc.view.*

class EncontroAdapter (var listaencontro: List<Encontro>):RecyclerView.Adapter<EncontroAdapter.EncontroViewHolder>(){
    class EncontroViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nome: TextView = itemView.tv_listencontro_nome
        val local: TextView = itemView.tv_listencontro_endereco
        val descricao: TextView = itemView.tv_listencontro_descricao

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EncontroViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.enc, parent, false)

        return EncontroViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaencontro.size
    }

    override fun onBindViewHolder(holder:EncontroViewHolder, position: Int) {
        val encontro = listaencontro[position]

        holder.nome.text = encontro.name
        holder.local.text = encontro.local
        holder.descricao.text = encontro.descricao

    }
}