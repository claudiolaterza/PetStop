package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import br.com.receitasdecodigo.utils.MaskEditUtil
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.domain.FeiraAdocao
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class CriarFeiraAdocaoActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var voltar : ImageView
    private lateinit var dbref : DatabaseReference
    private lateinit var confirma : ImageView
    private lateinit var add : ImageView

    private lateinit var endereco : EditText
    private lateinit var lat : EditText
    private lateinit var long : EditText
    private lateinit var name : EditText
    private lateinit var data : EditText

    private lateinit var mMap : GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_feira_adocao)

        voltar = findViewById(R.id.voltar_criar_feiraadocao)
        data = findViewById(R.id.et_data_criar_feiraadocao)

        data.addTextChangedListener(MaskEditUtil.mask(data, MaskEditUtil.FORMAT_DATE));


        voltar.setOnClickListener{
            var y = Intent(this, FeiraAdocaoActivity::class.java)
            startActivity(y)
            finish()
        }

        val user = Firebase.auth.currentUser
        val id = user.uid

        confirma = findViewById(R.id.add_feira_adocao)

        lat = findViewById(R.id.et_latitude_criar_feiraadocao)
        long = findViewById(R.id.et_longitude_criar_feiraadocao)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapa_add_feira_adocao) as SupportMapFragment
        mapFragment.getMapAsync(this)

        confirma.setOnClickListener{

            @Override
            data = findViewById(R.id.et_data_criar_feiraadocao)
            name = findViewById(R.id.et_nome_criar_feiraadocao)
            endereco = findViewById(R.id.et_endereco_criar_feiraadocao)
            lat = findViewById(R.id.et_latitude_criar_feiraadocao)
            long = findViewById(R.id.et_longitude_criar_feiraadocao)

            val d = data.getText().toString()
            val n = name.getText().toString()
            val e = endereco.getText().toString()
            val la = lat.getText().toString()
            val lo = long.getText().toString()

            if(d.isEmpty() || n.isEmpty() || e.isEmpty() || la.isEmpty() || lo.isEmpty()){
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
            } else{
                criarFeiraAdocao(id,d,n,e, la, lo)
                Toast.makeText(this, "Cadastro feito com sucesso!", Toast.LENGTH_LONG).show()
                var y = Intent(this, FeiraAdocao::class.java)
                startActivity(y)
                finish()
            }
        }
    }

    fun criarFeiraAdocao(id: String?, name: String?, endereco: String?, lat: String?, long: String?, data: String?){
        dbref = FirebaseDatabase.getInstance().getReference("FeiraAdocao")
        val feiraadocao = FeiraAdocao(id, name,endereco, lat, long, data)
        dbref.child(id.toString()).setValue(feiraadocao)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val brasilia = LatLng(-15.7859944, -47.9043957)
        mMap.addMarker(
            MarkerOptions()
            .position(brasilia)
            .title("Defina a localização do Pet Perdido!"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng((brasilia)))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(brasilia, 13f))

        mMap.setOnMapClickListener {
            mMap.clear()
            mMap.addMarker(MarkerOptions().position(it))
            mMap.moveCamera(CameraUpdateFactory.newLatLng((it)))
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(it, 12f))
            lat.setText(it.latitude.toString())
            long.setText(it.longitude.toString())
        }

    }

}