package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.domain.FeiraAdocao
import br.iesb.mobile.petstop.domain.PetFriendly
import br.iesb.mobile.petstop.domain.Petshop
import br.iesb.mobile.petstop.ui.adapter.FeirasAdocaoAdapter
import br.iesb.mobile.petstop.ui.adapter.PetFriendlyAdapter
import com.google.firebase.database.*

class LocalPetFriendlyActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var petfriendlyRecyclerView: RecyclerView
    private lateinit var petfriendlyArrayList : ArrayList<PetFriendly>
    private lateinit var voltar : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_pet_friendly)

        petfriendlyRecyclerView = findViewById(R.id.rv_ac_petfriendly)
        petfriendlyRecyclerView.layoutManager = LinearLayoutManager(this)
        petfriendlyRecyclerView.setHasFixedSize(true)

        petfriendlyArrayList = arrayListOf<PetFriendly>()
        getUserData()

        voltar = findViewById(R.id.voltar_petfriendly)

        voltar.setOnClickListener{
            var a = Intent(this, MenuComunidadeActivity::class.java)
            startActivity(a)
            finish()
        }
    }

    private fun getUserData(){
        dbref = FirebaseDatabase.getInstance().getReference("LocalPetFriendly")

        dbref.addValueEventListener(object : ValueEventListener, PetFriendlyAdapter.ClickPetfriendly {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(local_petfriendlySnapshot in snapshot.children){
                        val petfriendly = local_petfriendlySnapshot.getValue(PetFriendly::class.java)
                        petfriendlyArrayList.add(petfriendly!!)
                    }
                    petfriendlyRecyclerView.adapter = PetFriendlyAdapter(petfriendlyArrayList, this)
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

            override fun clickPetfriendly(petfriendly: PetFriendly) {
                val intent = Intent(this@LocalPetFriendlyActivity, PerfilPetFriendlyActivity::class.java)
                intent.putExtra("nome", petfriendly.name)
                intent.putExtra("local", petfriendly.local)
                intent.putExtra("latitude", petfriendly.latitude)
                intent.putExtra("longitude", petfriendly.longitude)
                startActivity(intent)
                finish()
            }
        })
    }
}