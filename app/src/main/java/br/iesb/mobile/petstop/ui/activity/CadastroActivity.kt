package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.databinding.ActivityCadastroBinding
import br.iesb.mobile.petstop.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private var auth = FirebaseAuth.getInstance()
    lateinit var voltar : Button

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        voltar = findViewById(R.id.bt_actv_voltar_cadastro)


        voltar.setOnClickListener{
            var x = Intent(this, LoginActivity::class.java)
            startActivity(x)
            finish()
        }

        binding.atvBtCadastrar.setOnClickListener(){view ->
            val email = binding.atvEtEmailCadastro.text.toString()
            val senha = binding.atvEtPassCadastro.text.toString()

            if(email.isEmpty() || senha.isEmpty()){
                Toast.makeText(this, "Certifique-se de preencher todos os campos", Toast.LENGTH_LONG).show()
            }else{
                auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "Cadastro feito com sucesso!", Toast.LENGTH_LONG).show()
                        binding.atvEtEmailCadastro.setText("")
                        binding.atvEtPassCadastro.setText("")
                        var a = Intent(this, LoginActivity::class.java)
                        startActivity(a)
                        finish()
                    }
                }.addOnFailureListener{

                }
            }
        }

        binding.atvBtCadastro.setOnClickListener(){view ->
            val email = binding.atvEtEmailCadastro.text.toString()
            val senha = binding.atvEtPassCadastro.text.toString()

            if(email.isEmpty() || senha.isEmpty()){
                val snackbar = Snackbar.make(view, "Preencha todos os campos!", Snackbar.LENGTH_LONG)
                snackbar.setBackgroundTint(Color.BLACK)
                snackbar.show()
            }else{
                auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        val snackbar = Snackbar.make(view, "Sucesso ao cadastrar usuário!", Snackbar.LENGTH_LONG)
                        snackbar.setBackgroundTint(Color.BLACK)
                        snackbar.show()
                        binding.atvEtEmailCadastro.setText("")
                        binding.atvEtPassCadastro.setText("")
                        var a = Intent(this, LoginActivity::class.java)
                        startActivity(a)
                        finish()
                    }
                }.addOnFailureListener{

                }
            }
        }


    }

}