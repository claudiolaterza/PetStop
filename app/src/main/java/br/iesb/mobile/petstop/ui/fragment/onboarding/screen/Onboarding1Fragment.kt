package br.iesb.mobile.petstop.ui.fragment.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.iesb.mobile.petstop.databinding.FragmentOnboarding1Binding

class Onboarding1Fragment : Fragment() {

    private lateinit var binding: FragmentOnboarding1Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentOnboarding1Binding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }
}