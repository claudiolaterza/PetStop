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
import br.iesb.mobile.petstop.databinding.FragmentEncontrosBinding
import br.iesb.mobile.petstop.domain.Encontro
import br.iesb.mobile.petstop.ui.adapter.EncontroAdapter
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.enc.*
import kotlinx.android.synthetic.main.fragment_encontros.*

class EncontrosFragment : Fragment() {


    private lateinit var binding: FragmentEncontrosBinding
    private lateinit var adapter: EncontroAdapter

    var database = FirebaseDatabase.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEncontrosBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inicializarRecycler()
        getEncontro()

    }

    fun inicializarRecycler() {
        adapter = EncontroAdapter(listOf<Encontro>(
            Encontro(0, "","", "", "", "", 0 )
        ))
        listaEncontros.layoutManager = LinearLayoutManager(activity?.applicationContext)
        listaEncontros.adapter = adapter


    }

    private fun getEncontro() {

        val query = database.getReference("Encontros")

        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {

                val encontro = p0.children
                val lista = mutableListOf<Encontro>()
                encontro.forEach { p ->
                    val enc = p.getValue(Encontro::class.java)
                    if(enc!= null){
                        lista.add(enc)
                    }
                }
                adapter.listaencontro = lista.toList()
                adapter.notifyDataSetChanged()
            }
        })
    }

}