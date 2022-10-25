package br.iesb.mobile.petstop.ui.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import br.com.receitasdecodigo.utils.MaskEditUtil
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.domain.PetPerdido
import com.google.android.gms.common.GoogleApiAvailabilityLight
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

class CriarPetPerdidoActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var dbref : DatabaseReference

    private lateinit var name : EditText
    private lateinit var raca : EditText
    private lateinit var idade : EditText
    private lateinit var telefone : EditText
    private lateinit var email : EditText
    private lateinit var endereco : EditText
    private lateinit var data : EditText
    private lateinit var lat : EditText
    private lateinit var long : EditText
    private lateinit var desc : EditText
    private lateinit var mMap : GoogleMap
    private lateinit var voltar : ImageView
    private lateinit var confirma : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_pet_perdido)
        voltar = findViewById(R.id.voltar_criar_petperdido)
        voltar.setOnClickListener{
            var y = Intent(this, PetPerdidoActivity::class.java)
            startActivity(y)
            finish()
        }


        telefone = findViewById(R.id.et_telefone_criar_petperdido)
        data = findViewById(R.id.et_data_criar_petperdido)
        telefone.addTextChangedListener(MaskEditUtil.mask(telefone, MaskEditUtil.FORMAT_FONE));
        data.addTextChangedListener(MaskEditUtil.mask(data, MaskEditUtil.FORMAT_DATE));

        val user = Firebase.auth.currentUser
        val id = user.uid

        confirma = findViewById(R.id.add_petperdido)

        lat = findViewById(R.id.et_latitude_criar_petperdido)
        long = findViewById(R.id.et_longitude_criar_petperdido)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapa_add_petperdido) as SupportMapFragment
        mapFragment.getMapAsync(this)

        confirma.setOnClickListener{

            @Override
            telefone = findViewById(R.id.et_telefone_criar_petperdido)
            name = findViewById(R.id.et_nome_criar_petperdido)
            idade = findViewById(R.id.et_idade_criar_petperdido)
            raca = findViewById(R.id.et_raca_criar_petperdido)
            endereco = findViewById(R.id.et_endereco_criar_petperdido)
            data = findViewById(R.id.et_data_criar_petperdido)
            lat = findViewById(R.id.et_latitude_criar_petperdido)
            long = findViewById(R.id.et_longitude_criar_petperdido)
            email = findViewById(R.id.et_email_criar_petperdido)
            desc = findViewById(R.id.et_desc_criar_petperdido)



            val n = name.getText().toString()
            val ra = raca.getText().toString()
            val i = long.getText().toString()
            val t = telefone.getText().toString()
            val em = email.getText().toString()
            val e = endereco.getText().toString()
            val da = data.getText().toString()
            val la = lat.getText().toString()
            val lo = long.getText().toString()
            val de = desc.getText().toString()

            if(n.isEmpty() || ra.isEmpty() || i.isEmpty() || t.isEmpty() || em.isEmpty() || e.isEmpty() || da.isEmpty() || la.isEmpty() || lo.isEmpty() || de.isEmpty()){
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
            } else{
                criarPetPerdido(id, n, ra, i, e, la, lo, de, da)
                Toast.makeText(this, "Cadastro feito com sucesso!", Toast.LENGTH_LONG).show()
                var y = Intent(this, PetPerdidoActivity::class.java)
                startActivity(y)
                finish()
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val brasilia = LatLng(-15.7859944, -47.9043957)
        mMap.addMarker(MarkerOptions()
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

    fun criarPetPerdido(id: String?, name: String?, raca: String?, idade: String?, local: String?, latitude: String?, longitude: String?, descricao: String?, data: String?){
        dbref = FirebaseDatabase.getInstance().getReference("PetsPerdidos")
        val petperdido = PetPerdido(id, name, raca, idade, local, latitude, longitude, descricao, data)
        dbref.child(id.toString()).setValue(petperdido)
    }

}