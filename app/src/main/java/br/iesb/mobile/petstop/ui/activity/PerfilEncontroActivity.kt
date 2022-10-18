package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import br.iesb.mobile.petstop.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class PerfilEncontroActivity : AppCompatActivity() {

    private lateinit var campo_nome : TextView
    private lateinit var campo_local : TextView
    private lateinit var campo_data : TextView
    private lateinit var campo_lat : TextView
    private lateinit var campo_long : TextView
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
        campo_lat = findViewById(R.id.tv_lat_perfil_enc)
        campo_long = findViewById(R.id.tv_long_perfil_enc)
        campo_nome.setText(recuperarNome())
        campo_local.setText(recuperarLocal())
        campo_data.setText(recuperarData())
        campo_lat.setText(recuperarLat())
        campo_long.setText(recuperarLong())

        var lati : Double
        var longe : Double

        lati = campo_lat.text.toString().toDouble()
        longe = campo_long.text.toString().toDouble()

        val pos : LatLng
        pos = LatLng(lati,longe)


        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapa_encontro) as SupportMapFragment
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

    private fun recuperarLat (): String? {
        val lat = intent.getStringExtra("latitude")
        return lat
    }

    private fun recuperarLong (): String? {
        val long = intent.getStringExtra("longitude")
        return long
    }
}