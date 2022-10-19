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
import br.iesb.mobile.petstop.domain.Petshop
import br.iesb.mobile.petstop.domain.Usuario
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class CadastroActivity : AppCompatActivity() {

    private var auth = FirebaseAuth.getInstance()
    private lateinit var voltar : Button
    private lateinit var nome : EditText
    private lateinit var cpf : EditText
    private lateinit var tel : EditText
    private lateinit var conf_pass : EditText
    private lateinit var senha : EditText
    private lateinit var email : EditText
    private lateinit var dbref : DatabaseReference
    private lateinit var cadastrar : ImageView
    private lateinit var cadastro : TextView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        voltar = findViewById(R.id.bt_actv_voltar_cadastro)
        nome = findViewById(R.id.atv_nome_usu_cadastro)
        cpf = findViewById(R.id.atv_cpf_cadastro)
        tel = findViewById(R.id.atv_et_telefone_cadastro)
        conf_pass = findViewById(R.id.atv_et_confirm_pass_cadastro)
        senha = findViewById(R.id.atv_et_pass_cadastro)
        email = findViewById(R.id.atv_et_email_cadastro)
        cadastrar = findViewById(R.id.atv_bt_cadastrar)
        cadastro = findViewById(R.id.atv_bt_cadastro)

        val user = Firebase.auth.currentUser
        val id = user.uid

        voltar.setOnClickListener{
            var x = Intent(this, LoginActivity::class.java)
            startActivity(x)
            finish()
        }

        cadastrar.setOnClickListener(){
            val em = email.text.toString()
            val se = senha.text.toString()
            val cs = conf_pass.text.toString()
            val cp = cpf.text.toString()
            val te = tel.text.toString()
            val no = nome.text.toString()

            if(em.isEmpty() || se.isEmpty() || cs.isEmpty() || cp.isEmpty() || te.isEmpty() || no.isEmpty()){
                Toast.makeText(this, "Certifique-se de preencher todos os campos", Toast.LENGTH_LONG).show()
            }else if (se != cs) {
                Toast.makeText(this, "As senhas não coincidem!", Toast.LENGTH_LONG)
                    .show()
            }else if(se.length < 6 || cs.length <6){
                Toast.makeText(this, "A senha deve ter pelo menos 6 caracteres!", Toast.LENGTH_LONG).show()
            } else{
                auth.createUserWithEmailAndPassword(em, se).addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "Cadastro feito com sucesso!", Toast.LENGTH_LONG).show()
                        criarUsuario(cp, em, id, no,te)
                        var a = Intent(this, LoginActivity::class.java)
                        startActivity(a)
                        finish()
                    }
                }.addOnFailureListener{
                    Toast.makeText(this, "Digite um email válido!", Toast.LENGTH_LONG).show()
                }
            }
        }

        cadastro.setOnClickListener(){
            val em = email.text.toString()
            val se = senha.text.toString()
            val cs = conf_pass.text.toString()
            val cp = cpf.text.toString()
            val te = tel.text.toString()
            val no = nome.text.toString()

            if(em.isEmpty() || se.isEmpty() || cs.isEmpty() || cp.isEmpty() || te.isEmpty() || no.isEmpty()){
                Toast.makeText(this, "Certifique-se de preencher todos os campos", Toast.LENGTH_LONG).show()
            }else if (se != cs) {
                Toast.makeText(this, "As senhas não coincidem!", Toast.LENGTH_LONG)
                    .show()
            }else if(se.length < 6 || cs.length <6){
                Toast.makeText(this, "A senha deve ter pelo menos 6 caracteres!", Toast.LENGTH_LONG).show()
            } else{
                auth.createUserWithEmailAndPassword(em, se).addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "Cadastro feito com sucesso!", Toast.LENGTH_LONG).show()
                        criarUsuario(cp, em, id, no,te)
                        var a = Intent(this, LoginActivity::class.java)
                        startActivity(a)
                        finish()
                    }
                }.addOnFailureListener{
                    Toast.makeText(this, "Digite um email válido!", Toast.LENGTH_LONG).show()
                }
            }
        }


    }

    fun criarUsuario(cpf : String, email : String, id : String, name : String, cel : String){
        dbref = FirebaseDatabase.getInstance().getReference("Usuários")
        val user = Usuario(id, name, cpf, cel, email)
        dbref.child(id.toString()).setValue(user)
    }

}