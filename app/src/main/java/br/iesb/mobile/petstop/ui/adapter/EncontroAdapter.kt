package br.iesb.mobile.petstop.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.domain.Encontro
import kotlinx.android.synthetic.main.encontro_item.view.*


class EncontroAdapter(private val encontro : ArrayList<Encontro>, var clickEncontro: ClickEncontro) : RecyclerView.Adapter<EncontroAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.encontro_item,
            parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = encontro[position]

        holder.nome.text = currentitem.name
        holder.local.text = currentitem.local
        holder.latitude.text = currentitem.latitude.toString()

        holder.cardView.setOnClickListener{
            clickEncontro.clickEncontro(currentitem)
        }
    }

    override fun getItemCount(): Int {
        return encontro.size
    }

    interface ClickEncontro{
        fun clickEncontro(encontro: Encontro)

    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val nome : TextView = itemView.findViewById(R.id.tv_nome_encontro_actv)
        val local : TextView = itemView.findViewById(R.id.tv_end_encontro_actv)
        val latitude : TextView = itemView.findViewById(R.id.tv_data_encontro_actv)
        val cardView = itemView.card_encontro

    }

}