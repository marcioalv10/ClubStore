package br.com.cotemig.clubstore.ui.activities


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import br.com.cotemig.clubstore.R
import br.com.cotemig.clubstore.model.Account
import br.com.cotemig.clubstore.services.RetrofitInitializer
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.Theme
import retrofit2.Call
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var name: EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        email = findViewById(R.id.email)
        name = findViewById(R.id.name)
        password = findViewById(R.id.password)

        var check = findViewById<CheckBox>(R.id.adesao)

        var register = findViewById<Button>(R.id.register)
        register.setOnClickListener {


            if(email.text.toString().isNotEmpty()
                && name.text.toString().isNotEmpty()
                && password.text.toString().isNotEmpty()
            ){
                if(check.isChecked){
                    createAccount()
                }else{
                    MaterialDialog.Builder(this@RegisterActivity)
                        .theme(Theme.LIGHT)
                        .title(R.string.message_ops)
                        .content(R.string.check_lgpd)
                        .positiveText(R.string.button_ok).show()
                }


            }else{
                MaterialDialog.Builder(this@RegisterActivity)
                    .theme(Theme.LIGHT)
                    .title(R.string.message_ops)
                    .content("Todos os campos devem ser preenchidos")
                    .positiveText(R.string.button_ok).show()
            }


        }

    }
    //metodo para cadastrar o usuário
    fun createAccount(){

        //var name = findViewById<EditText>(R.id.name)
        //var password = findViewById<EditText>(R.id.password)

        var account = Account()

        account.name = name.text.toString()
        account.email = email.text.toString()
        account.password = password.text.toString()

        var s = RetrofitInitializer().serviceAccount()
        var call = s.create(account)

        call.enqueue(object : retrofit2.Callback<Account>{
            override fun onFailure(call: Call<Account>, t: Throwable) {

                MaterialDialog.Builder(this@RegisterActivity)
                    .theme(Theme.LIGHT)
                    .title(R.string.message_ops)
                    .content(R.string.generic_error)
                    .positiveText(R.string.button_ok).show()


            }

            override fun onResponse(call: Call<Account>, response: Response<Account>) {


                if(response.code() == 200){
                    MaterialDialog.Builder(this@RegisterActivity)
                        .theme(Theme.LIGHT)
                        .title(R.string.sucess)
                        .content(R.string.success_message)
                        .positiveText(R.string.button_ok)
                        .onPositive { dialog, which ->
                            var intent = Intent(this@RegisterActivity, HomeActivity::class.java)
                            intent.putExtra("name", name.text.toString())
                            startActivity(intent)
                            finish()
                        }.show()
                }else if(response.code() == 409){
                    MaterialDialog.Builder(this@RegisterActivity)
                        .theme(Theme.LIGHT)
                        .title(R.string.message_ops)
                        .content(R.string.user_reset_message)
                        .positiveText(R.string.button_yes)
                        .onPositive { dialog, which ->
                            showforgot()
                        }
                        .negativeText(R.string.button_no)
                        .show()
                }




            }

        })


    }

    //metodo direciona para a tela de redefinição se senha
    fun showforgot(){
        var intent = Intent(this, ForgotActivity::class.java)
        intent.putExtra("email", email.text.toString())
        startActivity(intent)
        finish()
    }
}