package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import br.iesb.mobile.petstop.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

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

        var lati : Double
        var longe : Double

        lati = latitude.text.toString().toDouble()
        longe = longitude.text.toString().toDouble()

        val pos : LatLng
        pos = LatLng(lati,longe)


        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapa_feiraadocao) as SupportMapFragment
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