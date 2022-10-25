package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import br.com.receitasdecodigo.utils.MaskEditUtil
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
    private lateinit var domicilio : CheckBox
    private lateinit var curriculo : EditText
    private lateinit var name : EditText
    private lateinit var telefone : EditText
    private lateinit var voltar : ImageView

    private lateinit var anestesia : CheckBox
    private lateinit var cardiologia : CheckBox
    private lateinit var cirurgia : CheckBox
    private lateinit var clinica : CheckBox
    private lateinit var dermatologia : CheckBox
    private lateinit var endocrinologia : CheckBox
    private lateinit var neurologia : CheckBox
    private lateinit var nutricao : CheckBox
    private lateinit var nefro_uro : CheckBox
    private lateinit var odonto : CheckBox
    private lateinit var oftalmo : CheckBox
    private lateinit var ortopedia : CheckBox

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
        cpf = findViewById(R.id.et_cpf_criar_veterinario)
        cpf.addTextChangedListener(MaskEditUtil.mask(cpf, MaskEditUtil.FORMAT_CPF));

        telefone = findViewById(R.id.et_telefone_criar_veterinario)
        telefone.addTextChangedListener(MaskEditUtil.mask(telefone, MaskEditUtil.FORMAT_FONE))

        confirma.setOnClickListener{

            @Override
            name = findViewById(R.id.et_nome_criar_veterinario)
            cpf = findViewById(R.id.et_cpf_criar_veterinario)
            telefone = findViewById(R.id.et_telefone_criar_veterinario)
            email = findViewById(R.id.et_email_criar_veterinario)
            endereco = findViewById(R.id.et_endereco_criar_veterinario)
            curriculo = findViewById(R.id.et_currículo_criar_veterinario)
            domicilio = findViewById(R.id.et_domicilio_criar_veterinario1)

            anestesia = findViewById(R.id.anestesia_criar_vet)
            cardiologia = findViewById(R.id.cardiologia_criar_vet)
            cirurgia = findViewById(R.id.cirurgia_criar_vet)
            clinica = findViewById(R.id.clinica_criar_vet)
            dermatologia = findViewById(R.id.dermatologia_criar_vet)
            endocrinologia = findViewById(R.id.endocrinologia_criar_vet)
            neurologia = findViewById(R.id.neurologia_criar_vet)
            nutricao = findViewById(R.id.nutricao_criar_vet)
            nefro_uro = findViewById(R.id.nefro_criar_vet)
            odonto = findViewById(R.id.odontologia_criar_vet)
            oftalmo = findViewById(R.id.oftalmologia_criar_vet)
            ortopedia = findViewById(R.id.ortopedia_criar_vet)

            val dom : String
            dom = check_to_string2(domicilio)

            val ane : String
            ane = check_to_string(anestesia)
            val car : String
            car = check_to_string(cardiologia)
            val cir : String
            cir = check_to_string(cirurgia)
            val cli : String
            cli = check_to_string(clinica)
            val der : String
            der = check_to_string(dermatologia)
            val ende : String
            ende = check_to_string(endocrinologia)
            val neu : String
            neu = check_to_string(neurologia)
            val nut : String
            nut = check_to_string(nutricao)
            val nef : String
            nef = check_to_string(nefro_uro)
            val odo : String
            odo = check_to_string(odonto)
            val oft : String
            oft = check_to_string(oftalmo)
            val ort : String
            ort = check_to_string(ortopedia)

            val t = telefone.getText().toString()
            val n = name.getText().toString()
            val e = endereco.getText().toString()
            val cur = curriculo.getText().toString()
            val cp = cpf.getText().toString()
            val em = email.getText().toString()


            if(t.isEmpty() || n.isEmpty() || e.isEmpty() || cur.isEmpty() || cp.isEmpty() || em.isEmpty() ){
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
            } else{
                criarVeterinario(id, e, n, cp, em, t, dom, cur, ane, car, cir, cli, der, ende, neu, nut, nef, odo, oft, ort)
                Toast.makeText(this, "Cadastro feito com sucesso!", Toast.LENGTH_LONG).show()
                var y = Intent(this, VeterinarioActivity::class.java)
                startActivity(y)
                finish()
            }
        }
    }

    fun criarVeterinario(id: String?, endereco: String?, name: String?, cpf: String?, email: String?, telefone: String?, domicilio: String?, curriculo: String?,
                         anestesia : String?, cardiologia : String?, cirurgia : String?, clinica : String?, dermatologia : String?, endocrinologia : String?,
                         neurologia : String?, nutricao : String?, nefro_uro : String?, odonto : String?, oftalmo : String?, ortopedia : String?){
        dbref = FirebaseDatabase.getInstance().getReference("Veterinários")
        val vet = Veterinario(id, endereco, name, cpf, email, telefone, domicilio, curriculo, anestesia, cardiologia,
            cirurgia, clinica, dermatologia, endocrinologia, neurologia, nutricao, nefro_uro, odonto, oftalmo, ortopedia)
        dbref.child(id.toString()).setValue(vet)
    }

    fun check_to_string(check : CheckBox): String {
        if(check.isChecked){
            return "true"
        } else{
            return "false"
        }
    }

    fun check_to_string2(check : CheckBox): String {
        if(check.isChecked){
            return "Sim"
        } else{
            return "Não"
        }
    }

}