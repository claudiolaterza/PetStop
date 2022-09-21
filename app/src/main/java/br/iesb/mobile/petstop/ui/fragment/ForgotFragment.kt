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
import br.iesb.mobile.petstop.databinding.FragmentForgotBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_forgot.*
import android.widget.Toast


class ForgotFragment : Fragment() {

    private lateinit var binding: FragmentForgotBinding

    fun voltarParaLogin( v : View){
        findNavController().navigate(R.id.action_forgotFragment_to_loginFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgotBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.navforgot = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //BT Recuperação de Senha
        bt_forgot_forgot.setOnClickListener {
            val email = et_login_forgot.text.toString()
            val auth = FirebaseAuth.getInstance()

            Toast.makeText(activity, "Aguarde, em instantes você receberá um e-mail para recuperação de senha!", Toast.LENGTH_LONG).show()
            auth.sendPasswordResetEmail(email)
            findNavController().navigate(R.id.action_forgotFragment_to_loginFragment)
        }

        bt_forgot.setOnClickListener {
            val email = et_login_forgot.text.toString()
            val auth = FirebaseAuth.getInstance()

            Toast.makeText(activity, "Aguarde, em instantes você receberá um e-mail para recuperação de senha!", Toast.LENGTH_LONG).show()
            auth.sendPasswordResetEmail(email)
            findNavController().navigate(R.id.action_forgotFragment_to_loginFragment)        }
    }

}