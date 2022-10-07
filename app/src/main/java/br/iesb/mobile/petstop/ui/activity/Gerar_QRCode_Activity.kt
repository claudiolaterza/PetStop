package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.databinding.ActivityGerarQrcodeBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import kotlinx.android.synthetic.main.activity_gerar_qrcode.*

class Gerar_QRCode_Activity : AppCompatActivity() {

    private lateinit var ivQRcode : ImageView
    private lateinit var etData : EditText
    private lateinit var etIdade : EditText
    private lateinit var etRaca : EditText
    private lateinit var etVacinas : EditText
    private lateinit var btnGenerateQRcode : Button
    lateinit var voltar : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gerar_qrcode)

        ivQRcode = findViewById(R.id.ivQRCode)
        etData = findViewById(R.id.etData)
        etIdade = findViewById(R.id.etIdade)
        etRaca = findViewById(R.id.etRaca)
        etVacinas = findViewById(R.id.etVacinas)
        voltar = findViewById(R.id.voltar_gerar_qr)
        btnGenerateQRcode = findViewById(R.id.btnGenerateQRcode)

        voltar.setOnClickListener{
            var a = Intent(this, QRCodeActivity::class.java)
            startActivity(a)
            finish()
        }

        btnGenerateQRcode.setOnClickListener{

            var nome = etData.text.toString().trim()
            var idade = etIdade.text.toString().trim()
            var raca = etRaca.text.toString().trim()
            var vacinas = etVacinas.text.toString().trim()

            var code = "{ 'Nome': '" + nome + "', 'Idade': '" + idade + "', 'Raça': '" + raca + "', 'Vacinas': '" + vacinas + "'}"

            if(code.isEmpty()){
                Toast.makeText(this, "Digite algo", Toast.LENGTH_LONG).show()
            } else{
                val writer = QRCodeWriter()
                try{
                    val bitMatrix = writer.encode(code, BarcodeFormat.QR_CODE, 512, 512)
                    val width = bitMatrix.width
                    val height = bitMatrix.height
                    val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
                    for(x in 0 until width){
                        for(y in 0 until height){
                            bmp.setPixel(x, y, if(bitMatrix[x,y]) Color.BLACK else Color.WHITE)
                        }
                    }
                    ivQRcode.setImageBitmap(bmp)
                }catch(e: WriterException){
                    e.printStackTrace()
                }
            }
        }

    }

}