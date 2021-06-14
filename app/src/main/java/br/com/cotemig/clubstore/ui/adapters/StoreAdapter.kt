package br.com.cotemig.clubstore.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.clubstore.R
import br.com.cotemig.clubstore.model.Store
import coil.load

class StoreAdapter (var context: Context, var list: List<Store>):
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


    class StoreHolder(var view: View): RecyclerView.ViewHolder(view){

        fun bind(context: Context, store: Store){
/*

            if(store.tipo.equals("Oficina")){
                view.visibility = View.GONE
            }
*/
            var content = view.findViewById<RelativeLayout>(R.id.content_item_store)
            content.setOnClickListener {
                Toast.makeText(context, "Clicou ".plus(store.nome), Toast.LENGTH_LONG).show()
            }


            var name_store = view.findViewById<TextView>(R.id.name_store)
            name_store.text = store.nome

            var descricao_store = view.findViewById<TextView>(R.id.description)
            descricao_store.text = store.descricao

            var localizacao_store = view.findViewById<TextView>(R.id.location)
            localizacao_store.text = store.localizacao

            var image_cat = view.findViewById<ImageView>(R.id.image_category)

            if(store.tipo.equals("Sorveteria")){
                store.tipo = "https://mockup.fluo.app/assets/fatura/alimentacao.png"
            }else if(store.tipo.equals("Oficina")){
                store.tipo = "https://mockup.fluo.app/assets/fatura/servicos.png"
            }else{
                store.tipo = "https://mockup.fluo.app/assets/fatura/outros.png"
            }

            image_cat.load(store.tipo)

        }

    }


}