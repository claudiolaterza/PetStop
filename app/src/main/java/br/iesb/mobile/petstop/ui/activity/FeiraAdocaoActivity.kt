package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.domain.FeiraAdocao
import br.iesb.mobile.petstop.ui.adapter.FeirasAdocaoAdapter
import com.google.firebase.database.*

class FeiraAdocaoActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var feiraRecyclerView: RecyclerView
    private lateinit var feiraArrayList : ArrayList<FeiraAdocao>
    lateinit var voltar : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feira_adocao)

        feiraRecyclerView = findViewById(R.id.rv_ac_feira_adoc)
        feiraRecyclerView.layoutManager = LinearLayoutManager(this)
        feiraRecyclerView.setHasFixedSize(true)

        feiraArrayList = arrayListOf<FeiraAdocao>()
        getUserData()

        voltar = findViewById(R.id.voltar_atv_feira_adoc)

        voltar.setOnClickListener{
            var a = Intent(this, MenuComunidadeActivity::class.java)
            startActivity(a)
            finish()
        }

    }

    private fun getUserData(){
        dbref = FirebaseDatabase.getInstance().getReference("FeiraAdocao")

        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(feiraSnapshot in snapshot.children){
                        val feira = feiraSnapshot.getValue(FeiraAdocao::class.java)
                        feiraArrayList.add(feira!!)
                    }
                    feiraRecyclerView.adapter = FeirasAdocaoAdapter(feiraArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}