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
import br.iesb.mobile.petstop.domain.FeiraDoacao
import kotlinx.android.synthetic.main.feirasdoc.view.*
import kotlinx.android.synthetic.main.fragment_feiras_doacao.view.*

class FeirasDoacaoAdapter (var listafeirasdoc: List<FeiraDoacao>):RecyclerView.Adapter<FeirasDoacaoAdapter.FeirasDoacaoViewHolder>(){
    class FeirasDoacaoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nome: TextView = itemView.tv_listfeiradoac_nome
        val local: TextView = itemView.tv_listfeirdoac_local

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeirasDoacaoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.feirasdoc, parent, false)

        return FeirasDoacaoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listafeirasdoc.size
    }

    override fun onBindViewHolder(holder:FeirasDoacaoViewHolder, position: Int) {
        val feirasdoc = listafeirasdoc[position]

        holder.nome.text = feirasdoc.name
        holder.local.text = feirasdoc.local

    }
}