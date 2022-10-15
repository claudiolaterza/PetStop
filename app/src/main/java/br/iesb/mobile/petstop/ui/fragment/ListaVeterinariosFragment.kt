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
import br.iesb.mobile.petstop.databinding.FragmentListaVeterinariosBinding
import br.iesb.mobile.petstop.domain.Veterinario
import br.iesb.mobile.petstop.ui.adapter.VeterinarioAdapter
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_lista_veterinarios.*
import kotlinx.android.synthetic.main.vets.*
class ListaVeterinariosFragment : Fragment() {


    private lateinit var binding: FragmentListaVeterinariosBinding
    private lateinit var adapter: VeterinarioAdapter

    var database = FirebaseDatabase.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaVeterinariosBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getVeterinario()

    }


    private fun getVeterinario() {

        val query = database.getReference("Veterinários")

        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {

                val veterinario = p0.children
                val lista = mutableListOf<Veterinario>()
                veterinario.forEach { p ->
                    val vet= p.getValue(Veterinario::class.java)
                    if(vet!= null){
                        lista.add(vet)
                    }
                }
                adapter.listaveterinario = lista.toList()
                adapter.notifyDataSetChanged()
            }
        })
    }

}