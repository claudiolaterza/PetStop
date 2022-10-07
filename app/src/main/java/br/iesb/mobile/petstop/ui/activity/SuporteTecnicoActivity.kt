package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import br.iesb.mobile.petstop.R

class SuporteTecnicoActivity : AppCompatActivity() {

    lateinit var voltar : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suporte_tecnico)

        voltar = findViewById(R.id.voltar_atv_sup_tec)

        voltar.setOnClickListener{
            var a = Intent(this, MenuPrincipalActivity::class.java)
            startActivity(a)
            finish()
        }
    }

}