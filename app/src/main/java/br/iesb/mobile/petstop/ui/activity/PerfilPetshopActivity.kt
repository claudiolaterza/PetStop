package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import br.iesb.mobile.petstop.R

class PerfilPetshopActivity : AppCompatActivity() {

    private lateinit var campo_nome : TextView
    private lateinit var campo_local : TextView
    private lateinit var campo_telefone : TextView
    private lateinit var voltar : ImageView
    private lateinit var latitude : TextView
    private lateinit var longitude : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_petshop)

        voltar = findViewById(R.id.voltar_perfil_petshop)

        voltar.setOnClickListener{
            var y = Intent(this, PetShopActivity::class.java)
            startActivity(y)
            finish()
        }


        campo_telefone = findViewById(R.id.tv_telefone_perfil_petshop)
        campo_nome = findViewById(R.id.tv_nome_perfil_petshop)
        campo_local = findViewById(R.id.tv_local_perfil_petshop)
        longitude = findViewById(R.id.tv_longitude_perfil_petshop)
        latitude = findViewById(R.id.tv_latitude_perfil_petshop)
        campo_nome.setText(recuperarNome())
        campo_local.setText(recuperarLocal())
        campo_telefone.setText(recuperarTelefone())
        latitude.setText(recuperarLatitude())
        longitude.setText(recuperarLongitude())
    }

    private fun recuperarNome (): String? {

        val nome = intent.getStringExtra("nome")
        return nome.toString()
    }

    private fun recuperarLocal (): String? {

        val local = intent.getStringExtra("local")
        return local.toString()
    }

    private fun recuperarTelefone (): String? {
        val telefone = intent.getStringExtra("telefone")
        return telefone.toString()
    }

    private fun recuperarLatitude (): String? {
        val lat = intent.getStringExtra("latitude")
        return lat.toString()
    }

    private fun recuperarLongitude (): String? {
        val long = intent.getStringExtra("longitude")
        return long.toString()
    }
}