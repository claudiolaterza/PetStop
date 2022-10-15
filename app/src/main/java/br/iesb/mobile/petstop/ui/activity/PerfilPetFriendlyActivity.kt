package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import br.iesb.mobile.petstop.R

class PerfilPetFriendlyActivity : AppCompatActivity() {

    private lateinit var campo_nome : TextView
    private lateinit var campo_local : TextView
    private lateinit var voltar : ImageView
    private lateinit var latitude : TextView
    private lateinit var longitude : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_pet_friendly)

        voltar = findViewById(R.id.voltar_perfil_petfriendly)

        voltar.setOnClickListener{
            var y = Intent(this, LocalPetFriendlyActivity::class.java)
            startActivity(y)
            finish()
        }

        campo_nome = findViewById(R.id.tv_nome_perfil_petfriendly)
        campo_local = findViewById(R.id.tv_local_perfil_petfriendly)
        longitude = findViewById(R.id.tv_longitude_perfil_petfriendly)
        latitude = findViewById(R.id.tv_latitude_perfil_petfriendly)
        campo_nome.setText(recuperarNome())
        campo_local.setText(recuperarLocal())
        latitude.setText(recuperarLatitude())
        longitude.setText(recuperarLongitude())

    }

    private fun recuperarNome (): String? {

        val nome = intent.getStringExtra("nome")
        return nome
    }

    private fun recuperarLocal (): String? {

        val local = intent.getStringExtra("local")
        return local
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