package br.iesb.mobile.petstop.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.domain.PetFriendly

class PetFriendlyAdapter(private val petfriendly : ArrayList<PetFriendly>) : RecyclerView.Adapter<PetFriendlyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.petfriendly_item,
        parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = petfriendly[position]

        holder.nome.text = currentitem.name
        holder.local.text = currentitem.local
        holder.latitude.text = currentitem.latitude.toString()

    }

    override fun getItemCount(): Int {
        return petfriendly.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nome : TextView = itemView.findViewById(R.id.tv_nome_petfriendly_actv)
        val local : TextView = itemView.findViewById(R.id.tv_end_petfriendly_actv)
        val latitude : TextView = itemView.findViewById(R.id.tv_data_petfriendly_actv)
    }









}