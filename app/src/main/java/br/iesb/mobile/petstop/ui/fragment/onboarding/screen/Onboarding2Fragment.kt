package br.iesb.mobile.petstop.ui.fragment.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.iesb.mobile.petstop.databinding.FragmentOnboarding2Binding

class Onboarding2Fragment : Fragment() {

    private lateinit var binding: FragmentOnboarding2Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentOnboarding2Binding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }
}