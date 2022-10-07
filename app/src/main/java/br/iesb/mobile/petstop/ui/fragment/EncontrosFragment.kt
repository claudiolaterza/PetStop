package br.iesb.mobile.petstop.ui.fragment
//
//import android.os.Bundle
//import androidx.databinding.DataBindingUtil.setContentView
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import br.iesb.mobile.petstop.R
//import br.iesb.mobile.petstop.domain.Encontro
//import br.iesb.mobile.petstop.ui.adapter.EncontroAdapter
//import com.google.firebase.database.*
//
//class EncontrosFragment : Fragment() {
//
//
//    private lateinit var dbref : DatabaseReference
//    private lateinit var encontroRecyclerView: RecyclerView
//    private lateinit var encontroArrayList : ArrayList<Encontro>
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_encontros)
//
//        encontroRecyclerView = findViewById()
//        encontroRecyclerView.layoutManager = LinearLayoutManager(this)
//        encontroRecyclerView.setHasFixedSize(true)
//
//        encontroArrayList = arrayListOf<Encontro>()
//        getUserData()
//    }
//
//    private fun getUserData(){
//        dbref = FirebaseDatabase.getInstance().getReference("Encontros")
//
//        dbref.addValueEventListener(object : ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                if(snapshot.exists()){
//                    for(feiraSnapshot in snapshot.children){
//                        val feira = feiraSnapshot.getValue(Encontro::class.java)
//                        encontroArrayList.add(encontro!!)
//                    }
//                    encontroRecyclerView.adapter = EncontroAdapter(encontroArrayList)
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//
//            }
//
//        })
//    }
//}