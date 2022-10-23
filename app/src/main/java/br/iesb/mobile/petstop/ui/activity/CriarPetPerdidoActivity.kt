package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import br.com.receitasdecodigo.utils.MaskEditUtil
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.domain.PetPerdido
import br.iesb.mobile.petstop.domain.Petshop
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class CriarPetPerdidoActivity : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference

    private lateinit var name : EditText
    private lateinit var raca : EditText
    private lateinit var idade : EditText
    private lateinit var telefone : EditText
    private lateinit var email : EditText
    private lateinit var endereco : EditText
    private lateinit var data : EditText
    private lateinit var lat : EditText
    private lateinit var long : EditText
    private lateinit var desc : EditText

    private lateinit var voltar : ImageView
    private lateinit var confirma : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_pet_perdido)

        voltar = findViewById(R.id.voltar_criar_petperdido)

        voltar.setOnClickListener{
            var y = Intent(this, PetPerdidoActivity::class.java)
            startActivity(y)
            finish()
        }

        telefone = findViewById(R.id.et_telefone_criar_petperdido)
        data = findViewById(R.id.et_data_criar_petperdido)
        telefone.addTextChangedListener(MaskEditUtil.mask(telefone, MaskEditUtil.FORMAT_FONE));
        data.addTextChangedListener(MaskEditUtil.mask(data, MaskEditUtil.FORMAT_DATE));


        val user = Firebase.auth.currentUser
        val id = user.uid

        confirma = findViewById(R.id.add_petperdido)

        confirma.setOnClickListener{

            @Override
            telefone = findViewById(R.id.et_telefone_criar_petperdido)
            name = findViewById(R.id.et_nome_criar_petperdido)
            idade = findViewById(R.id.et_idade_criar_petperdido)
            raca = findViewById(R.id.et_raca_criar_petperdido)
            endereco = findViewById(R.id.et_endereco_criar_petperdido)
            data = findViewById(R.id.et_data_criar_petperdido)
            lat = findViewById(R.id.et_latitude_criar_petperdido)
            long = findViewById(R.id.et_longitude_criar_petperdido)
            email = findViewById(R.id.et_email_criar_petperdido)
            desc = findViewById(R.id.et_desc_criar_petperdido)

            val n = name.getText().toString()
            val ra = raca.getText().toString()
            val i = long.getText().toString()
            val t = telefone.getText().toString()
            val em = email.getText().toString()
            val e = endereco.getText().toString()
            val da = data.getText().toString()
            val la = lat.getText().toString()
            val lo = long.getText().toString()
            val de = desc.getText().toString()

            if(n.isEmpty() || ra.isEmpty() || i.isEmpty() || t.isEmpty() || em.isEmpty() || e.isEmpty() || da.isEmpty() || la.isEmpty() || lo.isEmpty() || de.isEmpty()){
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
            } else{
                criarPetPerdido(id, n, ra, i, e, la, lo, de, da)
                Toast.makeText(this, "Cadastro feito com sucesso!", Toast.LENGTH_LONG).show()
                var y = Intent(this, PetPerdidoActivity::class.java)
                startActivity(y)
                finish()
            }
        }
    }

    fun criarPetPerdido(id: String?, name: String?, raca: String?, idade: String?, local: String?, latitude: String?, longitude: String?, descricao: String?, data: String?){
        dbref = FirebaseDatabase.getInstance().getReference("PetsPerdidos")
        val petperdido = PetPerdido(id, name, raca, idade, local, latitude, longitude, descricao, data)
        dbref.child(id.toString()).setValue(petperdido)
    }
}