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

class PetshopAdapter (var petshops: List<Petshop>, var clickPetshop: ClickPetshop):RecyclerView.Adapter<PetshopAdapter.PetshopViewHolder>(){
    class PetshopViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
         val nome: TextView = itemView.tv_nome_petshop_actv;
         val endereco: TextView = itemView.tv_end_petshop_actv;
         val telefone: TextView = itemView.tv_tel_petshop_actv;
         val latitude: TextView = itemView.tv_lat_petshop_actv;
         val longitude: TextView = itemView.tv_long_petshop_actv;
        val venda_produtos: TextView = itemView.tv_venda_prod_item_petshop
        val banho: TextView = itemView.tv_banho_item_petshop
        val tosa: TextView = itemView.tv_tosa_item_petshop
        val serv_veterinario: TextView = itemView.tv_serv_veterinario_item_petshop
        val exames: TextView = itemView.tv_exames_item_petshop
        val internacao: TextView = itemView.tv_internacao_item_petshop
        val atendimento_24h: TextView = itemView.tv_atendimento24h_item_petshop
         val cardView = itemView.card_petshop
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetshopViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.petshop_item,
                parent, false)
        return PetshopViewHolder(view)
    }

    override fun getItemCount(): Int {
        return petshops.size
    }

    interface ClickPetshop{
        fun clickPetshop(petshop: Petshop)
    }

    override fun onBindViewHolder(holder: PetshopViewHolder, position: Int) {
        val petshop = petshops[position]
        holder.nome.text = petshop.name.toString()
        holder.endereco.text = petshop.endereco.toString()
        holder.telefone.text = petshop.telefone.toString()
        holder.latitude.text = petshop.lat.toString()
        holder.longitude.text = petshop.long.toString()

        holder.venda_produtos.text = petshop.venda_produtos.toString()
        holder.banho.text = petshop.banho.toString()
        holder.tosa.text = petshop.tosa.toString()
        holder.serv_veterinario.text = petshop.serv_veteterinaio.toString()
        holder.exames.text = petshop.exame.toString()
        holder.internacao.text = petshop.internacao.toString()
        holder.atendimento_24h.text = petshop.atendimento_24h.toString()

        holder.cardView.setOnClickListener{
            clickPetshop.clickPetshop(petshop)
        }

    }

}

