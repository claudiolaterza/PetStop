package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.domain.FeiraDoacao
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class CriarFeiraDoacaoActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var confirma : ImageView
    private lateinit var endereco : EditText
    private lateinit var lat : EditText
    private lateinit var long : EditText
    private lateinit var name : EditText
    private lateinit var voltar : ImageView
    private lateinit var data : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_feira_doacao)

        voltar = findViewById(R.id.voltar_criar_feiradoacao)

        voltar.setOnClickListener{
            var y = Intent(this, FeiraDoacaoActivity::class.java)
            startActivity(y)
            finish()
        }

        val user = Firebase.auth.currentUser
        val id = user.uid

        confirma = findViewById(R.id.add_feira_doacao)

        confirma.setOnClickListener{

            @Override
            data = findViewById(R.id.et_data_criar_feiradoacao)
            name = findViewById(R.id.et_nome_criar_feiradoacao)
            endereco = findViewById(R.id.et_endereco_criar_feiradoacao)
            lat = findViewById(R.id.et_latitude_criar_feiradoacao)
            long = findViewById(R.id.et_longitude_criar_feiradoacao)


            val d = data.getText().toString()
            val n = name.getText().toString()
            val e = endereco.getText().toString()
            val la = lat.getText().toString()
            val lo = long.getText().toString()


            if(d.isEmpty() || n.isEmpty() || e.isEmpty() || la.isEmpty() || lo.isEmpty()){
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
            } else{
                criarFeiraDoacao(id,d,n,e, la, lo)
                Toast.makeText(this, "Cadastro feito com sucesso!", Toast.LENGTH_LONG).show()
                var y = Intent(this, FeiraDoacao::class.java)
                startActivity(y)
                finish()
            }
        }
    }

    fun criarFeiraDoacao(id: String?, name: String?, endereco: String?, lat: String?, long: String?, data: String?){
        dbref = FirebaseDatabase.getInstance().getReference("FeiraDoacao")
        val feiradoacao = FeiraDoacao(id, name,endereco,lat, long, data)
        dbref.child(id.toString()).setValue(feiradoacao)
    }
}