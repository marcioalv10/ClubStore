package br.com.cotemig.clubstore.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import br.com.cotemig.clubstore.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        var signup = findViewById<Button>(R.id.signup)
        signup.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        var remember = findViewById<TextView>(R.id.remenberPassword)
        remember.setOnClickListener {
            var intent = Intent(this, ForgotActivity::class.java)
            startActivity(intent)
        }



    }
}