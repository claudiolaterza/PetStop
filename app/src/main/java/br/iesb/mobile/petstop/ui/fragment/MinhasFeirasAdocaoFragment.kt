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
import br.iesb.mobile.petstop.databinding.FragmentMinhasFeirasAdocaoBinding
import br.iesb.mobile.petstop.domain.FeiraAdocao
import br.iesb.mobile.petstop.ui.adapter.FeirasAdocaoAdapter
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.feirasadoc.*
import kotlinx.android.synthetic.main.fragment_minhas_feiras_adocao.*

class MinhasFeirasAdocaoFragment : Fragment() {


    private lateinit var binding: FragmentMinhasFeirasAdocaoBinding
    private lateinit var adapter: FeirasAdocaoAdapter

    var database = FirebaseDatabase.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMinhasFeirasAdocaoBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inicializarRecycler()
        getFeiraAdoc()

    }

    fun inicializarRecycler() {
        adapter = FeirasAdocaoAdapter(listOf<FeiraAdocao>(
            FeiraAdocao(0, "","", 0, 0, 0)
        ))
        listaFeirasAdocao.layoutManager = LinearLayoutManager(activity?.applicationContext)
        listaFeirasAdocao.adapter = adapter


    }

    private fun getFeiraAdoc() {

        val query = database.getReference("FeiraAdocao")

        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {

                val feiraadoc = p0.children
                val lista = mutableListOf<FeiraAdocao>()
                feiraadoc.forEach { p ->
                    val fadoc = p.getValue(FeiraAdocao::class.java)
                    if(fadoc!= null){
                        lista.add(fadoc)
                    }
                }
                adapter.listafeirasadoc = lista.toList()
                adapter.notifyDataSetChanged()
            }
        })
    }

}