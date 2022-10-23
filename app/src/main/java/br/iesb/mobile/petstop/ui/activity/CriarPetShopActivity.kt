package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import br.com.receitasdecodigo.utils.MaskEditUtil
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.domain.Petshop
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_criar_pet_shop.*

class CriarPetShopActivity : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference
    private lateinit var confirma : ImageView
    private lateinit var cnpj : EditText
    private lateinit var email : EditText
    private lateinit var endereco : EditText
    private lateinit var lat : EditText
    private lateinit var long : EditText
    private lateinit var name : EditText
    private lateinit var telefone : EditText
    private lateinit var voltar : ImageView

    private lateinit var venda_produtos : CheckBox
    private lateinit var banho : CheckBox
    private lateinit var tosa : CheckBox
    private lateinit var serv_veterinario : CheckBox
    private lateinit var exames : CheckBox
    private lateinit var internacao : CheckBox
    private lateinit var atendimento_24h : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_pet_shop)

        telefone = findViewById(R.id.et_telefone_criar_petshop)
        cnpj = findViewById(R.id.et_cnpj_criar_petshop)
        cnpj.addTextChangedListener(MaskEditUtil.mask(cnpj, "##.###.###/####-##"));
        telefone.addTextChangedListener(MaskEditUtil.mask(telefone, MaskEditUtil.FORMAT_FONE));

        voltar = findViewById(R.id.voltar_criar_petshop)

        voltar.setOnClickListener{
            var y = Intent(this, PetShopActivity::class.java)
            startActivity(y)
            finish()
        }

        val user = Firebase.auth.currentUser
        val id = user.uid

        confirma = findViewById(R.id.add_new_petshop)

        confirma.setOnClickListener{

            @Override
            telefone = findViewById(R.id.et_telefone_criar_petshop)
            name = findViewById(R.id.et_nome_criar_petshop)
            endereco = findViewById(R.id.et_endereco_criar_petshop)
            lat = findViewById(R.id.et_latitude_criar_petshop)
            long = findViewById(R.id.et_longitude_criar_petshop)
            cnpj = findViewById(R.id.et_cnpj_criar_petshop)
            email = findViewById(R.id.et_email_criar_petshop)

            venda_produtos = findViewById(R.id.serv_venda_produtos_criar)
            banho = findViewById(R.id.serv_banho_criar)
            tosa = findViewById(R.id.serv_tosa_criar)
            serv_veterinario = findViewById(R.id.serv_veterinario_criar)
            exames = findViewById(R.id.serv_exame_criar)
            internacao = findViewById(R.id.serv_internacao_criar)
            atendimento_24h = findViewById(R.id.serv_atendimento24_criar)

            val t = telefone.getText().toString()
            val n = name.getText().toString()
            val e = endereco.getText().toString()
            val la = lat.getText().toString()
            val lo = long.getText().toString()
            val cn = cnpj.getText().toString()
            val em = email.getText().toString()

            val ven : String
            ven = check_to_string(venda_produtos)
            val ban : String
            ban = check_to_string(banho)
            val tos : String
            tos = check_to_string(tosa)
            val ser : String
            ser = check_to_string(serv_veterinario)
            val exa : String
            exa = check_to_string(exames)
            val int : String
            int = check_to_string(internacao)
            val ate : String
            ate = check_to_string(atendimento_24h)

            if(t.isEmpty() || n.isEmpty() || e.isEmpty() || la.isEmpty() || lo.isEmpty() || cn.isEmpty() || em.isEmpty() ){
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
            } else{
                criarPetshop(t, id, n, e, la, lo, cn, em, ven, ban, tos, ser, exa, int, ate)
                Toast.makeText(this, "Cadastro feito com sucesso!", Toast.LENGTH_LONG).show()
                var y = Intent(this, PetShopActivity::class.java)
                startActivity(y)
                finish()
            }
        }
    }

    fun criarPetshop(telefone: String?, id: String?, name: String?, endereco: String?, lat: String?, long: String?, cnpj: String?,email: String?,
                     venda_produtos : String?, banho : String?, tosa : String?, serv_veterinario : String?, exames : String?, internacao : String?, atendimento_24h : String?
    ){
        dbref = FirebaseDatabase.getInstance().getReference("PetShops")
        val petshop = Petshop(id, telefone,name,endereco,lat, long, cnpj.toString(),email, venda_produtos, banho, exames, tosa, serv_veterinario, internacao, atendimento_24h)
        dbref.child(id.toString()).setValue(petshop)
    }

    fun check_to_string(check : CheckBox): String {
        if(check.isChecked){
            return "true"
        } else{
            return "false"
        }
    }
}