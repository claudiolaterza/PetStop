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
import br.iesb.mobile.petstop.domain.FeiraAdocao
import kotlinx.android.synthetic.main.feirasadoc.view.*

class FeirasAdocaoAdapter (var listafeirasadoc: List<FeiraAdocao>):RecyclerView.Adapter<FeirasAdocaoAdapter.FeirasAdocaoViewHolder>(){
    class FeirasAdocaoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nome: TextView = itemView.tv_listfeiraad_nome
        val local: TextView = itemView.tv_istfeiraad_local

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeirasAdocaoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.feirasadoc, parent, false)

        return FeirasAdocaoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listafeirasadoc.size
    }

    override fun onBindViewHolder(holder:FeirasAdocaoViewHolder, position: Int) {
        val feirasadoc = listafeirasadoc[position]

        holder.nome.text = feirasadoc.name
        holder.local.text = feirasadoc.local

    }
}