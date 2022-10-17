package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.domain.Veterinario
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class CriarVeterinarioActivity : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference
    private lateinit var confirma : ImageView
    private lateinit var cpf : EditText
    private lateinit var email : EditText
    private lateinit var endereco : EditText
    private lateinit var domicilio : EditText
    private lateinit var curriculo : EditText
    private lateinit var name : EditText
    private lateinit var telefone : EditText
    private lateinit var voltar : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_veterinario)

        voltar = findViewById(R.id.voltar_criar_veterinario)

        voltar.setOnClickListener{
            var y = Intent(this, VeterinarioActivity::class.java)
            startActivity(y)
            finish()
        }

        val user = Firebase.auth.currentUser
        val id = user.uid

        confirma = findViewById(R.id.add_veterinario)

        confirma.setOnClickListener{

            @Override
            name = findViewById(R.id.et_nome_criar_veterinario)
            cpf = findViewById(R.id.et_cpf_criar_veterinario)
            telefone = findViewById(R.id.et_telefone_criar_veterinario)
            email = findViewById(R.id.et_email_criar_veterinario)
            endereco = findViewById(R.id.et_endereco_criar_veterinario)
            curriculo = findViewById(R.id.et_currículo_criar_veterinario)
            domicilio = findViewById(R.id.et_domicilio_criar_veterinario)


            val t = telefone.getText().toString()
            val n = name.getText().toString()
            val e = endereco.getText().toString()
            val cur = curriculo.getText().toString()
            val cp = cpf.getText().toString()
            val em = email.getText().toString()
            val dom = domicilio.getText().toString()

            if(t.isEmpty() || n.isEmpty() || e.isEmpty() || cur.isEmpty() || cp.isEmpty() || em.isEmpty() ){
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
            } else{
                criarVeterinario(id, e, n, cp, em, t, dom, cur)
                Toast.makeText(this, "Cadastro feito com sucesso!", Toast.LENGTH_LONG).show()
                var y = Intent(this, VeterinarioActivity::class.java)
                startActivity(y)
                finish()
            }
        }
    }

    fun criarVeterinario(id: String?, endereco: String?, name: String?, cpf: String?, email: String?, telefone: String?, domicilio: String?, curriculo: String?){
        dbref = FirebaseDatabase.getInstance().getReference("Veterinários")
        val vet = Veterinario(id, endereco, name, cpf, email, telefone, domicilio, curriculo)
        dbref.child(id.toString()).setValue(vet)
    }
}