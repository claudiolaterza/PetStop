package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.domain.Encontro
import br.iesb.mobile.petstop.domain.Veterinario
import br.iesb.mobile.petstop.ui.adapter.EncontroAdapter
import br.iesb.mobile.petstop.ui.adapter.VeterinarioAdapter
import com.google.firebase.database.*

class VeterinarioActivity : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference
    private lateinit var veterinarioRecyclerView: RecyclerView
    private lateinit var veterinarioArrayList : ArrayList<Veterinario>
    private lateinit var voltar : ImageView
    private lateinit var add : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_veterinario)

        veterinarioRecyclerView = findViewById(R.id.rv_ac_veterinario)
        veterinarioRecyclerView.layoutManager = LinearLayoutManager(this)
        veterinarioRecyclerView.setHasFixedSize(true)

        veterinarioArrayList = arrayListOf<Veterinario>()
        getUserData()

        voltar = findViewById(R.id.voltar_atv_veterinario)


        voltar.setOnClickListener{
            var a = Intent(this, MenuPrincipalActivity::class.java)
            startActivity(a)
            finish()
        }
        add = findViewById(R.id.add_new_vet)
        add.setOnClickListener{
            var b = Intent(this, CriarVeterinarioActivity::class.java)
            startActivity(b)
            finish()
        }

    }

    private fun getUserData(){
        dbref = FirebaseDatabase.getInstance().getReference("Veterinários")

        dbref.addValueEventListener(object : ValueEventListener,
            VeterinarioAdapter.ClickVeterinario {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(veterinarioSnapshot in snapshot.children){
                        val veterinario = veterinarioSnapshot.getValue(Veterinario::class.java)
                        veterinarioArrayList.add(veterinario!!)
                    }
                    veterinarioRecyclerView.adapter = VeterinarioAdapter(veterinarioArrayList, this)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

            override fun clickVeterinario(veterinario: Veterinario) {
                val intent = Intent(this@VeterinarioActivity, PerfilVeterinarioActivity::class.java)
                intent.putExtra("nome", veterinario.name)
                intent.putExtra("domicilio", veterinario.domicilio)
                intent.putExtra("local", veterinario.endereco)
                intent.putExtra("telefone", veterinario.telefone)
                intent.putExtra("curriculo", veterinario.curriculo)
                intent.putExtra("anestesia", veterinario.anestesia)
                intent.putExtra("cardiologia", veterinario.cardiologia)
                intent.putExtra("cirurgia", veterinario.cirurgia)
                intent.putExtra("clinica", veterinario.clinica)
                intent.putExtra("dermatologia", veterinario.dermatologia)
                intent.putExtra("endocrinologia", veterinario.endocrinologia)
                intent.putExtra("neurologia", veterinario.neurologia)
                intent.putExtra("nutricao", veterinario.nutricao)
                intent.putExtra("nefro_uro", veterinario.nefro_uro)
                intent.putExtra("odonto", veterinario.odonto)
                intent.putExtra("oftalmo", veterinario.oftalmo)
                intent.putExtra("ortopedia", veterinario.ortopedia)
                startActivity(intent)
                finish()
            }
        })
    }
}