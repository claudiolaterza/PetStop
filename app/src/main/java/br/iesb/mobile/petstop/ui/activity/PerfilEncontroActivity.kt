package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import br.iesb.mobile.petstop.R

class PerfilEncontroActivity : AppCompatActivity() {

    private lateinit var campo_nome : TextView
    private lateinit var campo_local : TextView
    private lateinit var campo_data : TextView
    private lateinit var voltar : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_encontro)

        voltar = findViewById(R.id.voltar_perfil_encontro)

        voltar.setOnClickListener{
            var y = Intent(this, EncontroActivity::class.java)
            startActivity(y)
            finish()
        }

        campo_data = findViewById(R.id.tv_data_perfil_encontro)
        campo_nome = findViewById(R.id.tv_nome_perfil_encontro)
        campo_local = findViewById(R.id.tv_endereco_perfil_encontro)
        campo_nome.setText(recuperarNome())
        campo_local.setText(recuperarLocal())
        campo_data.setText(recuperarData())

    }

    private fun recuperarNome (): String? {

        val nome = intent.getStringExtra("nome")
        return nome
    }

    private fun recuperarLocal (): String? {

        val local = intent.getStringExtra("local")
        return local
    }

    private fun recuperarData (): String? {
        val data = intent.getStringExtra("data")
        return data
    }
}