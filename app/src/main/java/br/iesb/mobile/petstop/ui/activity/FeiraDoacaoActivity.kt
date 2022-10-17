package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.domain.FeiraDoacao
import br.iesb.mobile.petstop.domain.Petshop
import br.iesb.mobile.petstop.ui.adapter.FeirasDoacaoAdapter
import com.google.firebase.database.*

class FeiraDoacaoActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var feiraRecyclerView: RecyclerView
    private lateinit var feiraArrayList : ArrayList<FeiraDoacao>
    private lateinit var voltar_doac : ImageView
    private lateinit var add : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feira_doacao)

        feiraRecyclerView = findViewById(R.id.rv_ac_feira_doac)
        feiraRecyclerView.layoutManager = LinearLayoutManager(this)
        feiraRecyclerView.setHasFixedSize(true)

        feiraArrayList = arrayListOf<FeiraDoacao>()
        getUserData()

        voltar_doac = findViewById(R.id.voltar_atv_feira_doac)

        voltar_doac.setOnClickListener{
            var a = Intent(this, MenuComunidadeActivity::class.java)
            startActivity(a)
            finish()
        }

        add = findViewById(R.id.add_new_feiradoacao)

        add.setOnClickListener{
            var b = Intent(this, CriarFeiraDoacaoActivity::class.java)
                startActivity(b)
                finish()
            }
        }

    private fun getUserData(){
        dbref = FirebaseDatabase.getInstance().getReference("FeiraDoacao")

        dbref.addValueEventListener(object : ValueEventListener, FeirasDoacaoAdapter.ClickFeiraDoacao{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(feiraSnapshot in snapshot.children){
                        val feira = feiraSnapshot.getValue(FeiraDoacao::class.java)
                        feiraArrayList.add(feira!!)
                    }
                    feiraRecyclerView.adapter = FeirasDoacaoAdapter(feiraArrayList, this)
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

            override fun clickFeiraDoacao(feiradoacao: FeiraDoacao) {
                val intent = Intent(this@FeiraDoacaoActivity, PerfilFeiraDoacaoActivity::class.java)
                intent.putExtra("nome", feiradoacao.name)
                intent.putExtra("local", feiradoacao.local)
                intent.putExtra("data", feiradoacao.data)
                intent.putExtra("latitude", feiradoacao.latitude)
                intent.putExtra("longitude", feiradoacao.longitude)
                startActivity(intent)
                finish()
            }

        })
    }
}