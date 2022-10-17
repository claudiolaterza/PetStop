package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.domain.Encontro
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class CriarEncontroActivity : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference

    private lateinit var name : EditText
    private lateinit var data : EditText
    private lateinit var endereco : EditText
    private lateinit var lat : EditText
    private lateinit var long : EditText

    private lateinit var confirma : ImageView
    private lateinit var voltar : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_encontro)

        voltar = findViewById(R.id.voltar_criar_encontro)

        voltar.setOnClickListener{
            var y = Intent(this, EncontroActivity::class.java)
            startActivity(y)
            finish()
        }

        val user = Firebase.auth.currentUser
        val id = user.uid

        confirma = findViewById(R.id.add_encontro)

        confirma.setOnClickListener{

            @Override
            name = findViewById(R.id.et_nome_criar_encontro)
            data = findViewById(R.id.et_data_criar_encontro)
            endereco = findViewById(R.id.et_endereco_criar_encontro)
            lat = findViewById(R.id.et_latitude_criar_encontro)
            long = findViewById(R.id.et_longitude_criar_encontro)

            val da = data.getText().toString()
            val n = name.getText().toString()
            val e = endereco.getText().toString()
            val la = lat.getText().toString()
            val lo = long.getText().toString()


            if(da.isEmpty() || n.isEmpty() || e.isEmpty() || la.isEmpty() || lo.isEmpty()){
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
            } else{
                criarEncontro(id, n, da, e, la, lo)
                Toast.makeText(this, "Cadastro feito com sucesso!", Toast.LENGTH_LONG).show()
                var y = Intent(this, EncontroActivity::class.java)
                startActivity(y)
                finish()
            }
        }
    }

    fun criarEncontro(id: String?, name: String?, data: String?, endereco: String?, lat: String?, long: String?){
        dbref = FirebaseDatabase.getInstance().getReference("Encontros")
        val encontro = Encontro(id, lat, endereco, long, name, data)
        dbref.child(id.toString()).setValue(encontro)
    }
}