package br.iesb.mobile.petstop.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.databinding.FragmentComuMenuBinding


class ComuMenuFragment : Fragment() {
    private lateinit var binding: FragmentComuMenuBinding

    fun irParaEncontros(v: View){
        findNavController().navigate(R.id.action_comuMenuFragment_to_encontrosFragment)
    }

    fun irParaPetPerdido(v: View){
        findNavController().navigate(R.id.action_comuMenuFragment_to_petsPerdidosFragment)
    }

    fun irParaPetfriendly(v: View){
        findNavController().navigate(R.id.action_comuMenuFragment_to_localPetFriendlyFragment)
    }

    fun irParaFeirasAdocao(v: View){
        findNavController().navigate(R.id.action_comuMenuFragment_to_minhasFeirasAdocao)
    }

    fun irParaFeirasDoacao(v: View){
        findNavController().navigate(R.id.action_comuMenuFragment_to_minhasFeirasAdocao)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComuMenuBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.navcomumenu= this

        return binding.root
    }
}