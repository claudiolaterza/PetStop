package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.domain.FeiraDoacao
import br.iesb.mobile.petstop.ui.adapter.FeirasDoacaoAdapter

class MenuComunidadeActivity : AppCompatActivity() {

    lateinit var encontros : ImageView
    lateinit var voltar : ImageView
    lateinit var petf : ImageView
    lateinit var f_adoc : ImageView
    lateinit var f_doa : ImageView
    lateinit var perdidos : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_comunidade)

        encontros = findViewById(R.id.img_encontro_menu_comu)
        voltar = findViewById(R.id.voltar_atv_comu_menu_actv)
        petf = findViewById(R.id.img_petfriendly_menu_comu)
        f_adoc = findViewById(R.id.img_feiras_adoc_menu_comu)
        f_doa = findViewById(R.id.img_feira_doacao_menu_comu)
        perdidos = findViewById(R.id.img_perdidos_menu_comu)

        encontros.setOnClickListener{
            var a = Intent(this, EncontroActivity::class.java)
            startActivity(a)
            finish()
        }

        voltar.setOnClickListener{
            var b = Intent(this, MenuPrincipalActivity::class.java)
            startActivity(b)
            finish()
        }

        petf.setOnClickListener{
            var c = Intent(this, LocalPetFriendlyActivity::class.java)
            startActivity(c)
            finish()
        }
        f_adoc.setOnClickListener{
            var d = Intent(this, FeiraAdocaoActivity::class.java)
            startActivity(d)
            finish()
        }
        f_doa.setOnClickListener{
            var e = Intent(this, FeiraDoacaoActivity::class.java) //trocar por feira doação actv
            startActivity(e)
            finish()
        }
        perdidos.setOnClickListener{
            var f = Intent(this, PetPerdidoActivity::class.java) //trocar por petsperdidos actv
            startActivity(f)
            finish()
        }
    }
}