package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.domain.Petshop
import br.iesb.mobile.petstop.ui.adapter.PetshopAdapter
import com.google.firebase.database.*

class PetShopActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var petshopRecyclerView: RecyclerView
    private lateinit var petshopArrayList: ArrayList<Petshop>
    lateinit var voltar : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_shop)

        petshopRecyclerView = findViewById(R.id.rv_ac_petshop)
        petshopRecyclerView.layoutManager = LinearLayoutManager(this)
        petshopRecyclerView.setHasFixedSize(true)

        petshopArrayList = arrayListOf<Petshop>()
        getUserData()

        voltar = findViewById(R.id.voltar_atv_petshop)

        voltar.setOnClickListener{
            var a = Intent(this, MenuPrincipalActivity::class.java)
            startActivity(a)
            finish()
        }
    }

    private fun getUserData(){
        dbref = FirebaseDatabase.getInstance().getReference("PetShops")

        dbref.addValueEventListener(object : ValueEventListener, PetshopAdapter.ClickPetshop {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(petshopSnapshot in snapshot.children){
                        val petshop = petshopSnapshot.getValue(Petshop::class.java)
                        petshopArrayList.add(petshop!!)
                    }
                    petshopRecyclerView.adapter = PetshopAdapter(petshopArrayList, this)
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

            override fun clickPetshop(petshop: Petshop) {
                val intent = Intent(this@PetShopActivity, PerfilPetshopActivity::class.java)
                intent.putExtra("nome", petshop.name)
                intent.putExtra("local", petshop.endereco)
                intent.putExtra("telefone", petshop.telefone)
                intent.putExtra("latitude", petshop.lat)
                intent.putExtra("longitude", petshop.long)
                startActivity(intent)
                finish()
            }
        })
    }

}