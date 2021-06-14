package br.com.cotemig.clubstore.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.clubstore.R
import br.com.cotemig.clubstore.model.Store
import br.com.cotemig.clubstore.services.RetrofitInitializer
import br.com.cotemig.clubstore.ui.adapters.StoreAdapter
import retrofit2.Call
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var nameText = intent.getStringExtra("name")
        var name = findViewById<TextView>(R.id.name_user)

        name?.let {
            name.setText(nameText)
        }


        getStores()


    }

    fun getStores() {
        var s = RetrofitInitializer().serviceStore()
        var call = s.getStores()

        call.enqueue(object : retrofit2.Callback<List<Store>> {
            override fun onFailure(call: Call<List<Store>>, t: Throwable) {
                Toast.makeText(this@HomeActivity, "Ops", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Store>>, response: Response<List<Store>>) {
                if (response.code() == 200) {
                    response.body()?.let {
                        showStore(it)
                    }
                }
            }

        })


    }

    fun showStore(list: List<Store>) {
        var recyclerViewStore = findViewById<RecyclerView>(R.id.recyclerViewStore)
        recyclerViewStore.adapter = StoreAdapter(this, list)
        recyclerViewStore.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}
