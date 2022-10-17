package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.domain.PetPerdido
import br.iesb.mobile.petstop.ui.adapter.PetPerdidoAdapter
import com.google.firebase.database.*

class PetPerdidoActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var petperdidoRecyclerView: RecyclerView
    private lateinit var petperdidoArrayList: ArrayList<PetPerdido>
    private lateinit var voltar : ImageView
    private lateinit var add : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_perdido)

        petperdidoRecyclerView = findViewById(R.id.rv_ac_petperdido)
        petperdidoRecyclerView.layoutManager = LinearLayoutManager(this)
        petperdidoRecyclerView.setHasFixedSize(true)

        petperdidoArrayList = arrayListOf<PetPerdido>()
        getUserData()

        voltar = findViewById(R.id.voltar_atv_petperdido)

        voltar.setOnClickListener{
            var a = Intent(this, MenuPrincipalActivity::class.java)
            startActivity(a)
            finish()
        }

        add = findViewById(R.id.add_new_petperdido)
        add.setOnClickListener{
            var b = Intent(this, CriarPetPerdidoActivity::class.java)
            startActivity(b)
            finish()
        }

    }

    private fun getUserData(){
        dbref = FirebaseDatabase.getInstance().getReference("PetsPerdidos")

        dbref.addValueEventListener(object : ValueEventListener, PetPerdidoAdapter.ClickPetPerdido {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(petperdidoSnapshot in snapshot.children){
                        val petperdido = petperdidoSnapshot.getValue(PetPerdido::class.java)
                        petperdidoArrayList.add(petperdido!!)
                    }
                    petperdidoRecyclerView.adapter = PetPerdidoAdapter(petperdidoArrayList, this)
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

            override fun clickPetPerdido(petperdido: PetPerdido) {
                val intent = Intent(this@PetPerdidoActivity, PerfilPetPerdidoActivity::class.java)
                intent.putExtra("nome", petperdido.name)
                intent.putExtra("local", petperdido.local)
                intent.putExtra("descricao", petperdido.descricao)
                intent.putExtra("latitude", petperdido.latitude)
                intent.putExtra("longitude", petperdido.longitude)
                intent.putExtra("data", petperdido.data)
                intent.putExtra("raca", petperdido.raca)
                startActivity(intent)
                finish()
            }
        })
    }
}