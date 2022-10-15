package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import br.iesb.mobile.petstop.R

class PerfilFeiraAdocaoActivity : AppCompatActivity() {

    private lateinit var campo_nome : TextView
    private lateinit var campo_local : TextView
    private lateinit var data : TextView
    private lateinit var voltar : ImageView
    private lateinit var latitude : TextView
    private lateinit var longitude : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_feira_adocao)

        voltar = findViewById(R.id.voltar_perfil_feiraadocao)

        voltar.setOnClickListener{
            var y = Intent(this, FeiraAdocaoActivity::class.java)
            startActivity(y)
            finish()
        }

        data = findViewById(R.id.tv_data_perfil_feiraadocao)
        campo_nome = findViewById(R.id.tv_nome_perfil_feiraadocao)
        campo_local = findViewById(R.id.tv_local_perfil_feiraadocao)
        longitude = findViewById(R.id.tv_longitude_perfil_feiraadocao)
        latitude = findViewById(R.id.tv_latitude_perfil_feiraadocao)

        // setando os valores para os campos

        campo_nome.setText(recuperarNome())
        campo_local.setText(recuperarLocal())
        longitude.setText(recuperarLongitude())
        latitude.setText(recuperarLatitude())
        data.setText(recuperarData())
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

    private fun recuperarLatitude (): String? {
        val lat = intent.getStringExtra("latitude")
        return lat
    }

    private fun recuperarLongitude (): String? {
        val long = intent.getStringExtra("longitude")
        return long
    }
}