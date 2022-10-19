package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import br.iesb.mobile.petstop.R

class QRCodeActivity : AppCompatActivity() {
    lateinit var voltar : ImageView
    lateinit var gerar : ImageView
    lateinit var ler : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode)

        voltar = findViewById(R.id.voltar_atv_qrcode)
        gerar = findViewById(R.id.bt_gerar)
        ler = findViewById(R.id.bt_ler)

        voltar.setOnClickListener{
            var a = Intent(this, MenuPrincipalActivity::class.java)
            startActivity(a)
            finish()
        }

        gerar.setOnClickListener{
            var b = Intent(this, Gerar_QRCode_Activity::class.java)
            startActivity(b)
            finish()
        }

        ler.setOnClickListener{
            var c = Intent(this, LerQRCodeActivity::class.java)
            startActivity(c)
            finish()
        }

    }
}