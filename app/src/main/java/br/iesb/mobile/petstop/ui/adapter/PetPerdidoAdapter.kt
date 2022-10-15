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
import br.iesb.mobile.petstop.domain.PetPerdido
import android.util.Log
import kotlinx.android.synthetic.main.petperdido_item.view.*

class PetPerdidoAdapter (var petperdidos: List<PetPerdido>, var clickPetPerdido: ClickPetPerdido):RecyclerView.Adapter<PetPerdidoAdapter.PetPerdidoViewHolder>(){
    class PetPerdidoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nome: TextView = itemView.tv_nome_petperdido_actv;
        val local: TextView = itemView.tv_end_petperdido_actv;
        val descricao: TextView = itemView.tv_desc_petperdido_item;
        val latitude: TextView = itemView.tv_lat_petperdido_item;
        val longitude: TextView = itemView.tv_long_petperdido_item;
        val data: TextView = itemView.tv_data_petperdido_item_actv;
        val raca: TextView = itemView.tv_raca_petperdido_item;
        val cardView = itemView.card_petperdido
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetPerdidoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.petperdido_item,
                parent, false)
        return PetPerdidoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return petperdidos.size
    }

    interface ClickPetPerdido{
        fun clickPetPerdido(petperdido: PetPerdido)
    }

    override fun onBindViewHolder(holder: PetPerdidoViewHolder, position: Int) {
        val petperdido = petperdidos[position]

        holder.nome.text = petperdido.name.toString()
        holder.local.text = petperdido.local.toString()
        holder.descricao.text = petperdido.descricao.toString()
        holder.latitude.text = petperdido.latitude.toString()
        holder.longitude.text = petperdido.longitude.toString()
        holder.data.text = petperdido.data.toString()
        holder.raca.text = petperdido.raca.toString()

        holder.cardView.setOnClickListener{
            clickPetPerdido.clickPetPerdido(petperdido)
        }

    }

}

