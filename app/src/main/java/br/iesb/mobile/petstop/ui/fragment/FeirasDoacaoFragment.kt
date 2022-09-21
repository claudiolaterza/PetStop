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
import br.iesb.mobile.petstop.databinding.FragmentFeirasDoacaoBinding
import br.iesb.mobile.petstop.domain.FeiraDoacao
import br.iesb.mobile.petstop.ui.adapter.FeirasDoacaoAdapter
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.feirasdoc.*
import kotlinx.android.synthetic.main.fragment_feiras_doacao.*

class FeirasDoacaoFragment : Fragment() {


    private lateinit var binding: FragmentFeirasDoacaoBinding
    private lateinit var adapter: FeirasDoacaoAdapter

    var database = FirebaseDatabase.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeirasDoacaoBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inicializarRecycler()
        getFeiraDoc()

    }

    fun inicializarRecycler() {
        adapter = FeirasDoacaoAdapter(listOf<FeiraDoacao>(
            FeiraDoacao(0, "","", 0, 0, 0)
        ))
        listaFeirasDoacao.layoutManager = LinearLayoutManager(activity?.applicationContext)
        listaFeirasDoacao.adapter = adapter


    }

    private fun getFeiraDoc() {

        val query = database.getReference("FeiraDoacao")

        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {

                val feiradoc = p0.children
                val lista = mutableListOf<FeiraDoacao>()
                feiradoc.forEach { p ->
                    val fadoac = p.getValue(FeiraDoacao::class.java)
                    if(fadoac!= null){
                        lista.add(fadoac)
                    }
                }
                adapter.listafeirasdoc = lista.toList()
                adapter.notifyDataSetChanged()
            }
        })
    }

}