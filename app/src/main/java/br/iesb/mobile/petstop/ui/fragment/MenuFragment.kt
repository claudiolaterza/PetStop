package br.iesb.mobile.petstop.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.databinding.FragmentMenuBinding
import kotlinx.android.synthetic.main.fragment_login.*


class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    fun irParaComuMenu( v : View){
        findNavController().navigate(R.id.action_menuFragment_to_comuMenuFragment)
    }

    fun irParaVeterinario( v : View){
        findNavController().navigate(R.id.action_menuFragment_to_listaFragment2)
    }

    fun irParaPetshop( v : View){
        findNavController().navigate(R.id.action_menuFragment_to_petshopsFragment)
    }

    fun irParaChatbot( v : View){
        findNavController().navigate(R.id.action_menuFragment_to_chatbotFragment)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.navigation = this

        return binding.root
    }
}