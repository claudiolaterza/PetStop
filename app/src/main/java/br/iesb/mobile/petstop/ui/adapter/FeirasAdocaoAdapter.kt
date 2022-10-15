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
import kotlinx.android.synthetic.main.feira_item.view.*
import kotlinx.android.synthetic.main.feirasadoc.view.*
import kotlinx.android.synthetic.main.feirasdoc.view.*

class FeirasAdocaoAdapter(private val feira_adocao : ArrayList<FeiraAdocao>, var clickFeiraAdocao: ClickFeiraAdocao) : RecyclerView.Adapter<FeirasAdocaoAdapter.MyViewHolder>(){

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val nome : TextView = itemView.findViewById(R.id.tv_nome_feira_adoc_actv)
        val local : TextView = itemView.findViewById(R.id.tv_end_feira_adoc_actv)
        val latitude : TextView = itemView.findViewById(R.id.tv_lat_feira_adoc_actv)
        val longitude : TextView = itemView.findViewById(R.id.tv_long_feira_adoc_actv)
        val data : TextView = itemView.findViewById(R.id.tv_data_feira_adoc_actv)
        val cardView = itemView.card_feira
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feira_item,
        parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return feira_adocao.size
    }

    interface ClickFeiraAdocao{
        fun clickFeiraAdocao(feiraadocao: FeiraAdocao)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = feira_adocao[position]

        holder.nome.text = currentitem.name.toString()
        holder.local.text = currentitem.local.toString()
        holder.latitude.text = currentitem.latitude.toString()
        holder.longitude.text = currentitem.longitude.toString()
        holder.data.text = currentitem.data.toString()
        holder.cardView.setOnClickListener{
            clickFeiraAdocao.clickFeiraAdocao(currentitem)
        }
    }
}