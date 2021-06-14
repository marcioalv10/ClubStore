package br.com.cotemig.clubstore.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.clubstore.R
import br.com.cotemig.clubstore.model.Produto
import coil.load
import coil.transform.RoundedCornersTransformation
import java.text.NumberFormat
import java.util.*

class ProductAdapter(var context: Context, var product: List<Produto>):
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        var view = LayoutInflater.from(context).inflate(R.layout.item_produto, parent, false)

        return ProdutoHolder(view)

    }

    override fun getItemCount(): Int {
       return product.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ProdutoHolder).bind(product[position])
    }

    class  ProdutoHolder(var view: View): RecyclerView.ViewHolder(view){
        fun bind(produto: Produto){
            var nameProduto = view.findViewById<TextView>(R.id.nameProduto)
            nameProduto.text = produto.item

            var imageProduto = view.findViewById<ImageView>(R.id.imageProduto)
            imageProduto.load(produto.image){
                transformations(RoundedCornersTransformation(15f))
            }

            var precoProduto = view.findViewById<TextView>(R.id.preco)
            val locale_br = Locale("pt", "BR")
            val f = NumberFormat.getCurrencyInstance()
            precoProduto.text = f.format(produto.preco)


        }
    }

}