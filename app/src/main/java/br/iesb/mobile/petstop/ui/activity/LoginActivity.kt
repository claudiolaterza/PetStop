package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil.setContentView
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var auth = FirebaseAuth.getInstance()
    lateinit var cadastro : TextView
    lateinit var forgot : TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cadastro = findViewById(R.id.cadastra_text)
        forgot = findViewById(R.id.forgot_text)

        binding.imLogin.setOnClickListener(){view ->
            val email = binding.loginText.text.toString()
            val senha = binding.passText.text.toString()

            if(email.isEmpty() || senha.isEmpty()){
                Toast.makeText(this, "Certifique-se de preencher todos os campos!", Toast.LENGTH_LONG).show()
            }else{
                auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "Login efetuado com sucesso!", Toast.LENGTH_LONG).show()
                        binding.loginText.setText("")
                        binding.passText.setText("")
                        var a = Intent(this, MenuPrincipalActivity::class.java)
                        startActivity(a)
                        finish()
                    } else{
                        Toast.makeText(this, "Login ou senha incorretos!", Toast.LENGTH_LONG).show()
                    }
                }.addOnFailureListener{

                }
            }
        }

        cadastro.setOnClickListener{
            var b = Intent(this, CadastroActivity::class.java)
            startActivity(b)
            finish()
        }

        forgot.setOnClickListener{
            var c = Intent(this, ForgotActivity::class.java)
            startActivity(c)
            finish()
        }
    }
}


