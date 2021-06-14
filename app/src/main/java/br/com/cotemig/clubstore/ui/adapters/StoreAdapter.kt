package br.com.cotemig.clubstore.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.clubstore.R
import br.com.cotemig.clubstore.model.Store
import br.com.cotemig.clubstore.ui.activities.StoreDetailActivity
import coil.load
import coil.transform.RoundedCornersTransformation
import java.io.Serializable

class StoreAdapter(var context: Context, var list: List<Store>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {


        var view = LayoutInflater.from(context).inflate(R.layout.item_store, parent, false)

        return StoreHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as StoreHolder).bind(context, list[position])


    }


    class StoreHolder(var view: View) : RecyclerView.ViewHolder(view) {

        fun bind(context: Context, store: Store) {
/*

            if(store.tipo.equals("Oficina")){
                view.visibility = View.GONE
            }
*/
            var content = view.findViewById<RelativeLayout>(R.id.content_item_store)
            content.setOnClickListener {
                //Toast.makeText(context, "Clicou ".plus(store.nome), Toast.LENGTH_LONG).show()

                //Abrindo a activity Detail Store
                var intent = Intent(context, StoreDetailActivity::class.java)
                intent.putExtra("store", store)

                /* intent.putExtra("nomeLoja", store.nome)
                   intent.putExtra("localLoja", store.localizacao)
                   intent.putExtra("imageLoja", store.tipo)
                   intent.putExtra("descLoja", store.descricao)
                   intent.putExtra("produtosLoja", store.produtos.toString())*/

                context.startActivity(intent)

            }

            /* var produto = view.findViewById<RecyclerView>(R.id.lista_produtos)
            produto.adapter = ProductAdapter(context, store.produtos)
            produto.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)*/


            var name_store = view.findViewById<TextView>(R.id.name_store)
            name_store.text = store.nome

            var descricao_store = view.findViewById<TextView>(R.id.description)
            descricao_store.text = store.descricao

            var localizacao_store = view.findViewById<TextView>(R.id.location)
            localizacao_store.text = store.localizacao

            var image_cat = view.findViewById<ImageView>(R.id.image_category)
            var categoria: String

            var foto = view.findViewById<ImageView>(R.id.imageStore)
            foto.load(store.foto) {
                transformations(RoundedCornersTransformation(15f))
            }

            var logo = view.findViewById<ImageView>(R.id.image_logo)
            logo.load(store.logo) {
                transformations(RoundedCornersTransformation(50f))
            }


            if (store.tipo.equals("Alimentacao")) {
                categoria = "https://mockup.fluo.app/assets/fatura/alimentacao.png"
            } else if (store.tipo.equals("Oficina")) {
                categoria = "https://mockup.fluo.app/assets/fatura/servicos.png"
            } else if (store.tipo.equals("Educacao")) {
                categoria = "https://mockup.fluo.app/assets/fatura/educacao.png"
            } else {
                categoria = "https://mockup.fluo.app/assets/fatura/outros.png"
            }

            image_cat.load(categoria)

        }

    }


}