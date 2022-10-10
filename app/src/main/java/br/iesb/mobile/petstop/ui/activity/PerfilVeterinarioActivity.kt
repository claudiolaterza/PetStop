package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import br.iesb.mobile.petstop.R
import org.w3c.dom.Text

class PerfilVeterinarioActivity : AppCompatActivity() {

    private lateinit var voltar : ImageView
    private lateinit var campo_local : TextView
    private lateinit var campo_nome : TextView
    private lateinit var campo_domicilio : TextView

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
        campo_nome.setText(recuperarNome())
        campo_local.setText(recuperarEndereco())
        campo_domicilio.setText(recuperarDomicilio())

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

}