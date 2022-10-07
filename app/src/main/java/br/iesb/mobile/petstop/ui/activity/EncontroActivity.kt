package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.domain.Encontro
import br.iesb.mobile.petstop.ui.adapter.EncontroAdapter
import com.google.firebase.database.*

class EncontroActivity : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference
    private lateinit var encontroRecyclerView: RecyclerView
    private lateinit var encontroArrayList : ArrayList<Encontro>
    lateinit var voltar : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encontro)

        encontroRecyclerView = findViewById(R.id.rv_ac_encontro)
        encontroRecyclerView.layoutManager = LinearLayoutManager(this)
        encontroRecyclerView.setHasFixedSize(true)

        encontroArrayList = arrayListOf<Encontro>()
        getUserData()

        voltar = findViewById(R.id.voltar_atv_encontro)

        voltar.setOnClickListener{
            var a = Intent(this, MenuComunidadeActivity::class.java)
            startActivity(a)
            finish()
        }
    }

    private fun getUserData(){
        dbref = FirebaseDatabase.getInstance().getReference("Encontros")

        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(encontroSnapshot in snapshot.children){
                        val encontro = encontroSnapshot.getValue(Encontro::class.java)
                        encontroArrayList.add(encontro!!)
                    }
                    encontroRecyclerView.adapter = EncontroAdapter(encontroArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}