package br.iesb.mobile.petstop.ui.fragment
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.navigation.fragment.findNavController
//import br.iesb.mobile.petstop.R
//import br.iesb.mobile.petstop.databinding.FragmentCadastrarFeiraAdocaoBinding
//import br.iesb.mobile.petstop.databinding.FragmentMinhasFeirasAdocaoBinding
//
//
//class CadastrarFeiraAdocaoFragment : Fragment() {
//
//    private lateinit var binding: FragmentCadastrarFeiraAdocaoBinding
//
//    fun irParaMinhasFeirasAdocao( v : View){
//        findNavController().navigate(R.id.action_cadastrarFeiraAdocaoFragment_to_minhasFeirasAdocaoFragment)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentCadastrarFeiraAdocaoBinding.inflate(inflater, container, false)
//        binding.lifecycleOwner = this
//        binding.navcadastrarfeiraad = this
//        return binding.root
//
//    }
//}
