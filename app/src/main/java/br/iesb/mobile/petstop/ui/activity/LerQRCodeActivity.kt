package br.iesb.mobile.petstop.ui.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.domain.Pets
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class LerQRCodeActivity : AppCompatActivity() {

    lateinit var bt_ler_qrcode : Button
    private lateinit var nome : TextView
    private lateinit var idade : TextView
    private lateinit var raca : TextView
    private lateinit var vacina : TextView
    private lateinit var voltar : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ler_qrcode)

        bt_ler_qrcode = findViewById(R.id.bt_ler_qrcode)

        bt_ler_qrcode.setOnClickListener{
            val scanner = IntentIntegrator(this)

            scanner.initiateScan()
        }

        voltar = findViewById(R.id.voltar_atv_ler_qrcode)

        voltar.setOnClickListener{
            var a = Intent(this, QRCodeActivity::class.java)
            startActivity(a)
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        var pet : Pets

        nome = findViewById(R.id.nome_qr)
        idade = findViewById(R.id.idade_qr)
        raca = findViewById(R.id.raca_qr)
        vacina = findViewById(R.id.vacinas_qr)


        if(resultCode == Activity.RESULT_OK){
            val result : IntentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if(result != null){
                if(result.getContents() == null){
                    Toast.makeText(this, "Não foi encontrado nenhum registro", Toast.LENGTH_LONG).show()
                } else{

                    pet = Gson().fromJson(result.getContents(), Pets::class.java)
                    Toast.makeText(this, pet.Nome, Toast.LENGTH_LONG).show();
                    nome.setText(pet.Nome)
                    idade.setText(pet.Idade)
                    raca.setText(pet.Raça)
                    vacina.setText(pet.Vacinas)
                }
            } else{
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }
}