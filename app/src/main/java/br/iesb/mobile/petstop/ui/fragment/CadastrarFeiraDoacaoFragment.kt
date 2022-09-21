package br.iesb.mobile.petstop.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.databinding.FragmentCadastrarFeiraDoacaoBinding

class CadastrarFeiraDoacaoFragment : Fragment() {

    private lateinit var binding: FragmentCadastrarFeiraDoacaoBinding

    fun irParaFeirasDoacao( v : View){
         findNavController().navigate(R.id.action_cadastrarFeiraAdocaoFragment_to_minhasFeirasAdocaoFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCadastrarFeiraDoacaoBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.navcadastrarfeirado = this
        return binding.root

    }
}
