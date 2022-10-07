package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
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
    lateinit var voltar : ImageView

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

    }



    private fun getUserData(){
        dbref = FirebaseDatabase.getInstance().getReference("Veterinários")

        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(veterinarioSnapshot in snapshot.children){
                        val veterinario = veterinarioSnapshot.getValue(Veterinario::class.java)
                        veterinarioArrayList.add(veterinario!!)
                    }
                    veterinarioRecyclerView.adapter = VeterinarioAdapter(veterinarioArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}