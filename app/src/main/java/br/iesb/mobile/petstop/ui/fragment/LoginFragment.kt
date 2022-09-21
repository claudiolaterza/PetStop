package br.iesb.mobile.petstop.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.petstop.R
import android.widget.Toast
import br.iesb.mobile.petstop.databinding.FragmentLoginBinding
import br.iesb.mobile.petstop.ui.activity.MainActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    fun irParaCadastro(v: View) {

        findNavController().navigate(R.id.action_loginFragment_to_cadastroFragment)
    }

    fun irParaForgot(v: View) {
        findNavController().navigate(R.id.action_loginFragment_to_forgotFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.btnavlogin = this

        return binding.root

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //Autentica Firebase
        bt_entrar.setOnClickListener {
            val email = et_login.text.toString()
            val password = et_pass.text.toString()
            val auth = FirebaseAuth.getInstance()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(activity, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            } else {
                val taskDeLogin = auth.signInWithEmailAndPassword(email, password)
                taskDeLogin.addOnCompleteListener { resultado ->
                    if (resultado.isSuccessful) {
                        Toast.makeText(activity, "Login feito com sucesso!", Toast.LENGTH_LONG)
                            .show()
                        findNavController().navigate(R.id.action_loginFragment_to_menuFragment)
                    } else {
                        Toast.makeText(activity, "E-mail e/ou Senha Incorretos!", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }

        bt_login.setOnClickListener {
            val email = et_login.text.toString()
            val password = et_pass.text.toString()
            val auth = FirebaseAuth.getInstance()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(activity, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            } else {
                val taskDeLogin = auth.signInWithEmailAndPassword(email, password)
                taskDeLogin.addOnCompleteListener { resultado ->
                    if (resultado.isSuccessful) {
                        Toast.makeText(activity, "Login feito com sucesso!", Toast.LENGTH_LONG)
                            .show()
                        findNavController().navigate(R.id.action_loginFragment_to_menuFragment)
                    } else {
                        Toast.makeText(activity, "E-mail e/ou Senha Incorretos!", Toast.LENGTH_LONG)
                            .show()
                    }

                }


            }
        }
    }
}