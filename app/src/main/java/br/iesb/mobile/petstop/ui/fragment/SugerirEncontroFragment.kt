package br.iesb.mobile.petstop.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.databinding.FragmentSugerirEncontroBinding
import br.iesb.mobile.petstop.domain.Encontro
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_sugerir_encontro.*
import okhttp3.internal.toLongOrDefault


class SugerirEncontroFragment : Fragment() {

    lateinit var nomeLocal : EditText
    lateinit var endereco  : EditText
    lateinit var descricao : EditText
    private lateinit var binding: FragmentSugerirEncontroBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSugerirEncontroBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.navsugenc = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nomeLocal = view.findViewById(R.id.etNomeLocalEncontro)
        endereco = view.findViewById(R.id.etEnderecoEncontro)
        descricao = view.findViewById(R.id.etDescricaoEncontro)

        btSugerir.setOnClickListener{


        }

    }

}