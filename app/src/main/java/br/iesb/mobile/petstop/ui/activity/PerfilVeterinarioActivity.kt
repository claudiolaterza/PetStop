package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import br.iesb.mobile.petstop.R
import org.w3c.dom.Text

class PerfilVeterinarioActivity : AppCompatActivity() {

    private lateinit var voltar : ImageView
    private lateinit var campo_local : TextView
    private lateinit var campo_nome : TextView
    private lateinit var campo_domicilio : TextView
    private lateinit var campo_curriculo : TextView
    private lateinit var campo_telefone : TextView
    private lateinit var chk_dom : CheckBox

    private lateinit var chk_anestesia : CheckBox
    private lateinit var chk_cardiologia : CheckBox
    private lateinit var chk_cirurgia : CheckBox
    private lateinit var chk_clinica : CheckBox
    private lateinit var chk_dermatologia : CheckBox
    private lateinit var chk_endocrinologia : CheckBox
    private lateinit var chk_neurologia : CheckBox
    private lateinit var chk_nutricao : CheckBox
    private lateinit var chk_nefro_uro : CheckBox
    private lateinit var chk_odonto : CheckBox
    private lateinit var chk_oftalmo : CheckBox
    private lateinit var chk_ortopedia : CheckBox



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_veterinario)

        voltar = findViewById(R.id.voltar_perfil_veterinario)

        voltar.setOnClickListener{
            var y = Intent(this, VeterinarioActivity::class.java)
            startActivity(y)
            finish()
        }

        campo_domicilio = findViewById(R.id.tv_domicilio_perfil)
        campo_nome = findViewById(R.id.tv_nome_perfil_veterinario)
        campo_local = findViewById(R.id.tv_endereco_perfil_veterinario)
        campo_curriculo = findViewById(R.id.tv_curriculo_perfil_veterinario)
        campo_telefone = findViewById(R.id.tv_telefone_perfil_veterinario)
        campo_nome.setText(recuperarNome())
        campo_local.setText(recuperarEndereco())
        campo_domicilio.setText(recuperarDomicilio())
        campo_telefone.setText(recuperarTelefone())
        campo_curriculo.setText(recuperarCurriculo())
        chk_dom = findViewById(R.id.tv_domicilio_perfil1)
        chk_dom.isChecked = recuperarDomicilio() == "Sim"

        chk_anestesia = findViewById(R.id.anestesia_perfil)
        chk_cardiologia = findViewById(R.id.cardiologia_perfil)
        chk_cirurgia = findViewById(R.id.cirurgia_perfil)
        chk_clinica = findViewById(R.id.clinica_perfil)
        chk_dermatologia = findViewById(R.id.dermatologia_perfil)
        chk_endocrinologia = findViewById(R.id.endocrinologia_perfil)
        chk_neurologia = findViewById(R.id.neurologia_perfil)
        chk_nutricao = findViewById(R.id.nutricao_perfil)
        chk_nefro_uro = findViewById(R.id.nefro_perfil)
        chk_odonto = findViewById(R.id.odontologia_perfil)
        chk_oftalmo = findViewById(R.id.oftalmologia_perfil)
        chk_ortopedia = findViewById(R.id.ortopedia_perfil)

        chk_anestesia.isChecked = recuperarAnestesia() == "true"
        chk_cardiologia.isChecked = recuperarCardiologia() == "true"
        chk_cirurgia.isChecked = recuperarCirurgia() == "true"
        chk_clinica.isChecked = recuperarClinica() == "true"
        chk_dermatologia.isChecked = recuperarDermatologia() == "true"
        chk_endocrinologia.isChecked = recuperarEndocrinologia() == "true"
        chk_neurologia.isChecked = recuperarNeurologia() == "true"
        chk_nutricao.isChecked = recuperarNutricao() == "true"
        chk_nefro_uro.isChecked = recuperarNefro_uro() == "true"
        chk_odonto.isChecked = recuperarOdonto() == "true"
        chk_oftalmo.isChecked = recuperarOftalmo() == "true"
        chk_ortopedia.isChecked = recuperarOrtopedia() == "true"

    }

    private fun recuperarTelefone(): String?{
        val telefone = intent.getStringExtra("telefone")
        return telefone
    }

    private fun recuperarCurriculo(): String?{
        val curriculo = intent.getStringExtra("curriculo")
        return curriculo
    }

    private fun recuperarNome(): String?{
        val nome = intent.getStringExtra("nome")
        return nome
    }

    private fun recuperarDomicilio(): String?{
        val domicilio = intent.getStringExtra("domicilio")
        return domicilio
    }

    private fun recuperarEndereco(): String?{
        val local = intent.getStringExtra("local")
        return local
    }

    private fun recuperarAnestesia(): String?{
        val anestesia = intent.getStringExtra("anestesia")
        return anestesia
    }
    private fun recuperarCardiologia(): String?{
        val cardiologia = intent.getStringExtra("cardiologia")
        return cardiologia
    }
    private fun recuperarCirurgia(): String?{
        val cirurgia = intent.getStringExtra("cirurgia")
        return cirurgia
    }
    private fun recuperarClinica(): String?{
        val clinica = intent.getStringExtra("clinica")
        return clinica
    }
    private fun recuperarDermatologia(): String?{
        val dermatologia = intent.getStringExtra("dermatologia")
        return dermatologia
    }
    private fun recuperarEndocrinologia(): String?{
        val endocrinologia = intent.getStringExtra("endocrinologia")
        return endocrinologia
    }
    private fun recuperarNeurologia(): String?{
        val neurologia = intent.getStringExtra("neurologia")
        return neurologia
    }
    private fun recuperarNutricao(): String?{
        val nutricao = intent.getStringExtra("nutricao")
        return nutricao
    }
    private fun recuperarNefro_uro(): String?{
        val nefro_uro = intent.getStringExtra("nefro_uro")
        return nefro_uro
    }
    private fun recuperarOdonto(): String?{
        val odonto = intent.getStringExtra("odonto")
        return odonto
    }
    private fun recuperarOftalmo(): String?{
        val oftalmo = intent.getStringExtra("oftalmo")
        return oftalmo
    }
    private fun recuperarOrtopedia(): String?{
        val ortopedia = intent.getStringExtra("ortopedia")
        return ortopedia
    }

}