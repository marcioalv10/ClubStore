package br.com.cotemig.clubstore.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.clubstore.R
import br.com.cotemig.clubstore.model.Store
import br.com.cotemig.clubstore.ui.adapters.ProductAdapter
import coil.load
import coil.transform.RoundedCornersTransformation

class StoreDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_detail)

    // var store = intent.getSerializableExtra("Detail") as Store

        var store = intent.getSerializableExtra("store") as Store




   /*     var nomeLoja = intent.getStringExtra("nomeLoja")
        var localLoja = intent.getStringExtra("localLoja")
        var imageLoja = intent.getStringExtra("imageLoja")
        var descLoja = intent.getStringExtra("descLoja")
        var produtosLoja = intent.getStringExtra("produtosLoja")*/




        //Toast.makeText(this, store.localizacao, Toast.LENGTH_SHORT).show()

        var produto = findViewById<RecyclerView>(R.id.lista_produtos)
        produto.adapter = ProductAdapter(this, store.produtos)
        produto.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        var nameDetail = findViewById<TextView>(R.id.nameDetail)
        nameDetail.text = store.nome

        var imageStoreDetail = findViewById<ImageView>(R.id.imageStoreDetail)
        imageStoreDetail.load(store.foto)

        var enderecoStore = findViewById<TextView>(R.id.endereco)
        enderecoStore.text = store.localizacao

        var logo_detail = findViewById<ImageView>(R.id.logo_detail)
        logo_detail.load(store.logo){
            transformations(RoundedCornersTransformation(60f))
        }


        /* var produto = view.findViewById<RecyclerView>(R.id.lista_produtos)
           produto.adapter = ProductAdapter(context, store.produtos)
           produto.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)*/


    }
}