package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import br.iesb.mobile.petstop.R
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class PerfilPetshopActivity : AppCompatActivity() {

    private lateinit var campo_nome : TextView
    private lateinit var campo_local : TextView
    private lateinit var campo_telefone : TextView
    private lateinit var voltar : ImageView
    private lateinit var latitude : TextView
    private lateinit var longitude : TextView

    private lateinit var venda_produtos : CheckBox
    private lateinit var banho : CheckBox
    private lateinit var tosa : CheckBox
    private lateinit var serv_veterinario : CheckBox
    private lateinit var exames : CheckBox
    private lateinit var internacao : CheckBox
    private lateinit var atendimento_24h : CheckBox

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

        venda_produtos = findViewById(R.id.serv_venda_produtos_perfil)
        banho = findViewById(R.id.serv_banho_perfil)
        tosa = findViewById(R.id.serv_tosa_perfil)
        serv_veterinario = findViewById(R.id.serv_veterinario_perfil)
        exames = findViewById(R.id.serv_exame_perfil)
        internacao = findViewById(R.id.serv_internacao_perfil)
        atendimento_24h = findViewById(R.id.serv_atendimento24_perfil)

        venda_produtos.isChecked = recuperarVenda_produtos() == "true"
        banho.isChecked = recuperarBanho() == "true"
        tosa.isChecked = recuperarTosa() == "true"
        serv_veterinario.isChecked = recuperarServ_veterinario() == "true"
        exames.isChecked = recuperarExames() == "true"
        internacao.isChecked = recuperarInternacao() == "true"
        atendimento_24h.isChecked = recuperarAtendimento_24h() == "true"



        var lati : Double
        var longe : Double

        lati = latitude.text.toString().toDouble()
        longe = longitude.text.toString().toDouble()

        val pos : LatLng
        pos = LatLng(lati,longe)


        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapa_petshop) as SupportMapFragment
        mapFragment.getMapAsync{ googleMap ->
            googleMap.addMarker(
                MarkerOptions()
                    .title(campo_nome.text.toString())
                    .snippet(campo_local.text.toString())
                    .position(pos)
            )
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pos, 13f))
        }
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

    private fun recuperarVenda_produtos (): String? {
        val venda_produtos = intent.getStringExtra("venda_produtos")
        return venda_produtos.toString()
    }
    private fun recuperarBanho (): String? {
        val banho = intent.getStringExtra("banho")
        return banho.toString()
    }
    private fun recuperarTosa (): String? {
        val tosa = intent.getStringExtra("tosa")
        return tosa.toString()
    }
    private fun recuperarServ_veterinario (): String? {
        val serv_veterinario = intent.getStringExtra("serv_veterinario")
        return serv_veterinario.toString()
    }
    private fun recuperarExames (): String? {
        val exames = intent.getStringExtra("exame")
        return exames.toString()
    }
    private fun recuperarInternacao (): String? {
        val internacao = intent.getStringExtra("internacao")
        return internacao.toString()
    }
    private fun recuperarAtendimento_24h (): String? {
        val atendimento_24h = intent.getStringExtra("atendimento_24h")
        return atendimento_24h.toString()
    }

}