package br.iesb.mobile.petstop.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.R.layout.fragment_pets_perdidos
import br.iesb.mobile.petstop.databinding.FragmentCadastraPetPerdidoBinding
import br.iesb.mobile.petstop.domain.PetPerdido
import br.iesb.mobile.petstop.domain.Usuario
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_cadastra_pet_perdido.*
import kotlinx.android.synthetic.main.fragment_cadastro.*

class CadastraPetPerdidoFragment : Fragment() {

    private lateinit var binding: FragmentCadastraPetPerdidoBinding


    fun irParaPetsPerdidos(){
        findNavController().navigate(R.id.action_cadastraPetsPerdidosFragment_to_petsPerdidosFragment)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCadastraPetPerdidoBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.navcadastrapetperdidos = this
        return binding.root

        //return inflater.inflate(R.layout.fragment_encontros, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            bt_cadastra_pet_perdido.setOnClickListener {

                irParaPetsPerdidos()
            }

    }

}