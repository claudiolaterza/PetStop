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
import br.iesb.mobile.petstop.domain.Usuario
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private var auth = FirebaseAuth.getInstance()
    lateinit var voltar : Button
    lateinit var nome : EditText
    lateinit var cpf : EditText
    lateinit var tel : EditText
    lateinit var conf_pass : EditText

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        voltar = findViewById(R.id.bt_actv_voltar_cadastro)
        nome = findViewById(R.id.atv_nome_usu_cadastro)
        cpf = findViewById(R.id.atv_cpf_cadastro)
        tel = findViewById(R.id.atv_et_telefone_cadastro)
        conf_pass = findViewById(R.id.atv_et_confirm_pass_cadastro)


        voltar.setOnClickListener{
            var x = Intent(this, LoginActivity::class.java)
            startActivity(x)
            finish()
        }

        binding.atvBtCadastrar.setOnClickListener(){view ->
            val email = binding.atvEtEmailCadastro.text.toString()
            val senha = binding.atvEtPassCadastro.text.toString()

            if(email.isEmpty() || senha.isEmpty() || nome.text.toString().isEmpty() || cpf.text.toString().isEmpty() || tel.text.toString().isEmpty() || conf_pass.text.toString().isEmpty()){
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

            if(email.isEmpty() || senha.isEmpty() || nome.text.toString().isEmpty() || cpf.text.toString().isEmpty() || tel.text.toString().isEmpty() || conf_pass.text.toString().isEmpty()){
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
                    if(senha !== conf_pass.text.toString()) {
                        Toast.makeText(this, "Os capos de senha não coincidem!", Toast.LENGTH_LONG)
                            .show()
                    } else if(senha.length < 6 || conf_pass.text.toString().length <6){
                        Toast.makeText(this, "A senha deve ter pelo menos 6 caracteres!", Toast.LENGTH_LONG).show()
                    } else{
                        Toast.makeText(this, "O e-mail já está sendo utilizado!", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }


    }

}