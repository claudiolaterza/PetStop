package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import br.iesb.mobile.petstop.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import kotlinx.android.synthetic.main.activity_gerar_qrcode.*
import java.io.File
import java.io.FileOutputStream


class Gerar_QRCode_Activity : AppCompatActivity() {

    private lateinit var ivQRcode : ImageView
    private lateinit var etData : EditText
    private lateinit var etIdade : EditText
    private lateinit var etRaca : EditText
    private lateinit var etVacinas : EditText
    private lateinit var btnGenerateQRcode : Button
    lateinit var voltar : ImageView
    lateinit var compartilhar : ImageView


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
        compartilhar = findViewById(R.id.im_compartilhar_qr)

        voltar.setOnClickListener{
            var a = Intent(this, QRCodeActivity::class.java)
            startActivity(a)
            finish()
        }

        var img = ivQRCode

        compartilhar.setOnClickListener{

            val builder = VmPolicy.Builder()
            StrictMode.setVmPolicy(builder.build())

            //get da imagem como bitmap da imageview
            val myDrawable = img.drawable
            val bitmap = (myDrawable as BitmapDrawable).bitmap

            //compartilhar
//            val i = FileProvider.getUriForFile(
//                Gerar_QRCode_Activity.this,
//                "br.iesb.mobile.petstop.provider",
//                bitmap
//            )
            val file = File(externalCacheDir, getString(R.string.app_name)+".png")
            val fOut = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, fOut)
            fOut.flush()
            fOut.close()
            file.setReadable(true, false)
            val intent = Intent(Intent.ACTION_SEND)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK;
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file))
            intent.type = "image/png"
            intent.putExtra(Intent.EXTRA_SUBJECT, "PetCode")
            startActivity(Intent.createChooser(intent, "Enviar a imagem via:"))

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