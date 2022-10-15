package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import br.iesb.mobile.petstop.R

class PerfilPetPerdidoActivity : AppCompatActivity() {

    private lateinit var campo_nome : TextView
    private lateinit var campo_local : TextView
    private lateinit var campo_data : TextView
    private lateinit var voltar : ImageView
    private lateinit var latitude : TextView
    private lateinit var longitude : TextView
    private lateinit var campo_raca : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_pet_perdido)

        voltar = findViewById(R.id.voltar_perfil_petperdido)

        voltar.setOnClickListener{
            var y = Intent(this, PetPerdidoActivity::class.java)
            startActivity(y)
            finish()
        }

        campo_data = findViewById(R.id.tv_data_perfil_petperdido)
        campo_nome = findViewById(R.id.tv_nome_perfil_petperdido)
        campo_local = findViewById(R.id.tv_local_perfil_petperdido)
        campo_raca = findViewById(R.id.raca_perfil_petperdido)
        longitude = findViewById(R.id.tv_longitude_perfil_petperdido)
        latitude = findViewById(R.id.tv_latitude_perfil_petperdido)
        campo_nome.setText(recuperarNome())
        campo_local.setText(recuperarLocal())
        campo_data.setText(recuperarData())
        campo_raca.setText(recuperarRaca())
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

    private fun recuperarRaca (): String?{
        val raca = intent.getStringExtra("raca")
        return raca
    }

}