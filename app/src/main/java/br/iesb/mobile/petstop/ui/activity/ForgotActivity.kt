package br.iesb.mobile.petstop.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.databinding.ActivityForgotBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgot.*

class ForgotActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotBinding
    private var auth = FirebaseAuth.getInstance()
    lateinit var voltar : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        binding = ActivityForgotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        voltar = findViewById(R.id.bt_actv_voltar_forgot)


        voltar.setOnClickListener{
            var x = Intent(this, LoginActivity::class.java)
            startActivity(x)
            finish()
        }

        binding.actvBtForgot.setOnClickListener(){view ->
            val email = actv_et_login_forgot.text.toString()
            val auth = FirebaseAuth.getInstance()
            Toast.makeText(this, "Aguarde, em instantes você receberá um e-mail para recuperação de senha!", Toast.LENGTH_LONG).show()
            auth.sendPasswordResetEmail(email)
            var a = Intent(this, LoginActivity::class.java)
            startActivity(a)
            finish()
        }

        binding.actvBtForgotForgot.setOnClickListener() { view ->
            val email = actv_et_login_forgot.text.toString()
            val auth = FirebaseAuth.getInstance()

            Toast.makeText(
                this,
                "Aguarde, em instantes você receberá um e-mail para recuperação de senha!",
                Toast.LENGTH_LONG
            ).show()
            auth.sendPasswordResetEmail(email)
            var b = Intent(this, LoginActivity::class.java)
            startActivity(b)
            finish()
        }
    }
}