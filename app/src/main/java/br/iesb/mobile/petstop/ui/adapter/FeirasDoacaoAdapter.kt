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
import kotlinx.android.synthetic.main.feira_item.view.*

class FeirasDoacaoAdapter(private val feira_doacao : ArrayList<FeiraDoacao>, var clickFeiraDoacao: ClickFeiraDoacao) : RecyclerView.Adapter<FeirasDoacaoAdapter.MyViewHolder>(){

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
        return feira_doacao.size
    }

    interface ClickFeiraDoacao{
        fun clickFeiraDoacao(feiradoacao: FeiraDoacao)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = feira_doacao[position]

        holder.nome.text = currentitem.name.toString()
        holder.local.text = currentitem.local.toString()
        holder.latitude.text = currentitem.latitude.toString()
        holder.longitude.text = currentitem.longitude.toString()
        holder.data.text = currentitem.data.toString()
        holder.cardView.setOnClickListener{
            clickFeiraDoacao.clickFeiraDoacao(currentitem)
        }
    }
}