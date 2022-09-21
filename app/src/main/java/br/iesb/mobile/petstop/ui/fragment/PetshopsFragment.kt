package br.iesb.mobile.petstop.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import br.iesb.mobile.petstop.databinding.FragmentPetshopsBinding
import br.iesb.mobile.petstop.domain.Petshop
import br.iesb.mobile.petstop.ui.adapter.PetshopAdapter
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_petshops.*


class PetshopsFragment : Fragment() {

    private lateinit var binding: FragmentPetshopsBinding
    private lateinit var adapter: PetshopAdapter

    var database = FirebaseDatabase.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPetshopsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inicializarRecycler()
        getPetshop()

    }

    fun inicializarRecycler() {
        adapter = PetshopAdapter(listOf<Petshop>(Petshop(0, "","", 0, 0, 0, 0, "" )))
        listaPetsPerdidos.layoutManager = LinearLayoutManager(activity?.applicationContext)
        listaPetsPerdidos.adapter = adapter

    }

    private fun getPetshop() {

        val query = database.getReference("PetShops")

        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {

                val petshop = p0.children
                val lista = mutableListOf<Petshop>()
                petshop.forEach { p ->
                    val pet = p.getValue(Petshop::class.java)
                    if(pet!= null){
                        lista.add(pet)
                    }
                }
                adapter.listapetshops = lista.toList()
                adapter.notifyDataSetChanged()
            }
        })
    }

}