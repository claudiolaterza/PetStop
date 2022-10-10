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

        // botão voltar
        voltar = findViewById(R.id.voltar_atv_encontro)

        voltar.setOnClickListener{
            var a = Intent(this, MenuComunidadeActivity::class.java)
            startActivity(a)
            finish()
        }
    }

    private fun getUserData(){ //Coletando dados do firebase
        dbref = FirebaseDatabase.getInstance().getReference("Encontros")

        dbref.addValueEventListener(object : ValueEventListener, EncontroAdapter.ClickEncontro {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(encontroSnapshot in snapshot.children){
                        val encontro = encontroSnapshot.getValue(Encontro::class.java)
                        encontroArrayList.add(encontro!!)
                    }
                    encontroRecyclerView.adapter = EncontroAdapter(encontroArrayList, this)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

            override fun clickEncontro(encontro: Encontro) {

                Toast.makeText(this@EncontroActivity, encontro.name + " " + encontro.local, 3).show()

                val intent = Intent(this@EncontroActivity, PerfilEncontroActivity::class.java)
                intent.putExtra("nome", encontro.name)
                intent.putExtra("local", encontro.local)
                intent.putExtra("data", encontro.data)
                startActivity(intent)
                finish()
            }

        })
    }
}