package br.com.cotemig.clubstore.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import br.com.cotemig.clubstore.R
import br.com.cotemig.clubstore.model.Account
import br.com.cotemig.clubstore.services.RetrofitInitializer
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.Theme
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var email = findViewById<EditText>(R.id.email)
        var password = findViewById<EditText>(R.id.password)

        var signup = findViewById<Button>(R.id.signup)
        signup.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        var remember = findViewById<TextView>(R.id.remenberPassword)
        remember.setOnClickListener {
            var intent = Intent(this, ForgotActivity::class.java)
            intent.putExtra("email", email.text.toString())
            startActivity(intent)
        }

        var login = findViewById<Button>(R.id.login)
        login.setOnClickListener {

            if (!email.text.toString().isEmpty()) {
                authPassword(email.text.toString(), password.text.toString())
            } else {
                MaterialDialog.Builder(this@LoginActivity)
                    .theme(Theme.LIGHT)
                    .title(R.string.message_ops)
                    .content("Todos os campos devem ser preenchidos")
                    .positiveText(R.string.button_ok).show()
            }


        }


    }

    //TODO: criar o método para autenticar o usuário
    fun authPassword(email: String, password: String) {

        Log.i("Chave", "teste")

        var account = Account()
        account.email = email
        account.password = password

        var s = RetrofitInitializer().serviceAccount()
        var call = s.auth(account)

        var nome: String
        nome = account.name

        Log.i("Chave", account.name)
        Log.i("Chave", "teste2")

        call.enqueue(object : retrofit2.Callback<Account> {
            override fun onFailure(call: Call<Account>, t: Throwable) {
                MaterialDialog.Builder(this@LoginActivity)
                    .theme(Theme.LIGHT)
                    .title(R.string.message_ops)
                    .content("o conteudo não foi exibido")
                    .positiveText(R.string.button_ok).show()

            }

            override fun onResponse(call: Call<Account>, response: Response<Account>) {

                if (response.code() == 200) {
                    var intent = Intent(this@LoginActivity, HomeActivity::class.java)
                    intent.putExtra("name", nome)
                    Log.i("Chave", nome)
                    startActivity(intent)
                    finish()
                }

                if (response.code() == 403) {
                    MaterialDialog.Builder(this@LoginActivity)
                        .theme(Theme.LIGHT)
                        .title(R.string.message_ops)
                        .content("Ops! Email ou senha inválido")
                        .positiveText(R.string.button_ok).show()
                }

            }

        })

    }
}