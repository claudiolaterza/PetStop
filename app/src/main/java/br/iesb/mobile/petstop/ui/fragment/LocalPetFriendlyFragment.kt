package br.iesb.mobile.petstop.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.databinding.FragmentLocalPetFriendlyBinding


class LocalPetFriendlyFragment : Fragment() {

    private lateinit var binding: FragmentLocalPetFriendlyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocalPetFriendlyBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root

    }

}