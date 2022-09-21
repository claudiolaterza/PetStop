package br.iesb.mobile.petstop.ui.fragment

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.databinding.FragmentPetsPerdidosBinding
import br.iesb.mobile.petstop.domain.PetPerdido
import br.iesb.mobile.petstop.ui.adapter.PetPerdidoAdapter
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.petperdtv.*
import kotlinx.android.synthetic.main.fragment_pets_perdidos.*

class PetsPerdidosFragment : Fragment() {


    private lateinit var binding: FragmentPetsPerdidosBinding
    private lateinit var adapter: PetPerdidoAdapter

    var database = FirebaseDatabase.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPetsPerdidosBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inicializarRecycler()
        getPetPerdido()

    }

    fun inicializarRecycler() {
        adapter = PetPerdidoAdapter(listOf<PetPerdido>(
            PetPerdido(0, "","", "", "", "")
        ))
        listaPetsPerdidos.layoutManager = LinearLayoutManager(activity?.applicationContext)
        listaPetsPerdidos.adapter = adapter

    }

    private fun getPetPerdido() {

        val query = database.getReference("PetsPerdidos")

        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {

                val petperdido = p0.children
                val lista = mutableListOf<PetPerdido>()
                petperdido.forEach { p ->
                    val pp = p.getValue(PetPerdido::class.java)
                    if(pp!= null){
                        lista.add(pp)
                    }
                }
                adapter.listapetperdido = lista.toList()
                adapter.notifyDataSetChanged()
            }
        })
    }

}