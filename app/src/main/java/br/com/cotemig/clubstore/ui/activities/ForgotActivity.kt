package br.com.cotemig.clubstore.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.cotemig.clubstore.R
import br.com.cotemig.clubstore.model.Account
import br.com.cotemig.clubstore.services.RetrofitInitializer
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.Theme
import retrofit2.Call
import retrofit2.Response

class ForgotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        var emailText = intent.getStringExtra("email")

        var email = findViewById<EditText>(R.id.email)
        email.setText(emailText)

        var sendPassword = findViewById<Button>(R.id.sendPassword)
        sendPassword.setOnClickListener {

            if (!email.text.toString().isEmpty()) {
                sendPassword(email.text.toString())
            } else {
                MaterialDialog.Builder(this@ForgotActivity)
                    .theme(Theme.LIGHT)
                    .title(R.string.message_ops)
                    .content(R.string.preencha_email)
                    .positiveText(R.string.button_ok).show()
            }

        }

    }

    fun sendPassword(email: String) {
        var account = Account()
        account.email = email

        var s = RetrofitInitializer().serviceAccount()
        var call = s.forgot(account)

        call.enqueue(object : retrofit2.Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                MaterialDialog.Builder(this@ForgotActivity)
                    .theme(Theme.LIGHT)
                    .title(R.string.message_ops)
                    .content(R.string.generic_error)
                    .positiveText(R.string.button_ok).show()
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {

                if (response.code() == 204) {
                    //sucesso, enviou a senha por email
                    MaterialDialog.Builder(this@ForgotActivity)
                        .theme(Theme.LIGHT)
                        .title(R.string.sucess)
                        .content(R.string.senha_redefinida)
                        .positiveText(R.string.button_ok)
                        .onPositive { dialog, which ->
                            var intent = Intent(this@ForgotActivity, LoginActivity::class.java)
                            startActivity(intent)
                            finish()
                        }.show()


                } else if (response.code() == 404) {
                    //Usuario não existe
                    MaterialDialog.Builder(this@ForgotActivity)
                        .theme(Theme.LIGHT)
                        .title(R.string.message_ops)
                        .content(R.string.usuario_inexistente)
                        .positiveText(R.string.button_ok).show()
                }

            }

        })
    }
}