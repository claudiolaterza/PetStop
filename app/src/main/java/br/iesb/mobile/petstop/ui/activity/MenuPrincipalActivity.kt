package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import br.iesb.mobile.petstop.R


class MenuPrincipalActivity : AppCompatActivity() {

    lateinit var comunidade : ImageView
    lateinit var petshops : ImageView
    lateinit var veterinario : ImageView
    lateinit var sup_tec : ImageView
    lateinit var qr_code : ImageView
    lateinit var voltar : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        comunidade = findViewById(R.id.im_comu_menu_prin)
        petshops = findViewById(R.id.im_petshop_menu_prin)
        veterinario = findViewById(R.id.im_vet_menu_prin)
        sup_tec = findViewById(R.id.im_suporte_menu_prin)
        qr_code = findViewById(R.id.im_qrcode_menu_prin)
        voltar = findViewById(R.id.voltar_atv_menu_principal)

        voltar.setOnClickListener{
            var y = Intent(this, LoginActivity::class.java)
            startActivity(y)
            finish()
        }

        comunidade.setOnClickListener{
            var a = Intent(this, MenuComunidadeActivity::class.java)
            startActivity(a)
            finish()
        }

        petshops.setOnClickListener{
            var b = Intent(this, PetShopActivity::class.java)
            startActivity(b)
            finish()
        }

        veterinario.setOnClickListener{
            var c = Intent(this, VeterinarioActivity::class.java)
            startActivity(c)
            finish()
        }

        sup_tec.setOnClickListener{
            var d = Intent(this, SuporteTecnicoActivity::class.java)
            startActivity(d)
            finish()
        }

        qr_code.setOnClickListener{
            var e = Intent(this, QRCodeActivity::class.java)
            startActivity(e)
            finish()
        }




    }
}