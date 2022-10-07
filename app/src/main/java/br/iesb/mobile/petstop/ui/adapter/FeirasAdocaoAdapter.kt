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
import kotlinx.android.synthetic.main.feirasdoc.view.*

class FeirasAdocaoAdapter(private val feira_adocao : ArrayList<FeiraAdocao>) : RecyclerView.Adapter<FeirasAdocaoAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feira_item,
        parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = feira_adocao[position]

        holder.nome.text = currentitem.name
        holder.local.text = currentitem.local
        holder.latitude.text = currentitem.latitude.toString()
    }

    override fun getItemCount(): Int {
        return feira_adocao.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val nome : TextView = itemView.findViewById(R.id.tv_nome_feira_adoc_actv)
        val local : TextView = itemView.findViewById(R.id.tv_end_feira_adoc_actv)
        val latitude : TextView = itemView.findViewById(R.id.tv_data_feira_adoc_actv)
    }
}