
package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.ui.adapter.FeirasAdocaoAdapter

class MainActivity : AppCompatActivity() {

    lateinit var testebtn : Button
    lateinit var teste2btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testebtn = findViewById(R.id.TESTE)
        teste2btn = findViewById(R.id.TESTE2)

        testebtn.setOnClickListener{
            var i = Intent(this, CriarPetPerdidoActivity::class.java)
            startActivity(i)

        }

        teste2btn.setOnClickListener{
            var a = Intent(this, LoginActivity::class.java)
            startActivity(a)

        }
    }
}