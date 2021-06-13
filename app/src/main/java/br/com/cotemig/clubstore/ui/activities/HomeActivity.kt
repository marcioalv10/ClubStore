package br.com.cotemig.clubstore.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.cotemig.clubstore.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var nameText = intent.getStringExtra("name")
        var name = findViewById<TextView>(R.id.name_user)

        name?.let {
            name.setText(nameText)
        }




    }
}
