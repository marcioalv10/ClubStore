package br.com.cotemig.clubstore.model

import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import java.io.Serializable





/*
data class Store (
    var nome: String = "",
    var tipo: String = "",
    var descricao: String = "",
    var localizacao: String = "",
   var produtos: List<Produto> = emptyList()

): Serializable
*/



data class Store (
    var nome: String = "",
    var tipo: String = "",
    var descricao: String = "",
    var localizacao: String = "",
    var foto: String = "",
    var logo: String = "",
    var produtos: List<Produto> = emptyList()

): Serializable



/*
data class Store (
    var nome: String = "",
    var tipo: String = "",
    var descricao: String = "",
    var localizacao: String = "",
   var produtos: List<Produto> = emptyList()

)
*/

/*
class Store {
    var nome: String = ""
    var tipo: String = ""
    var descricao: String = ""
    var localizacao: String = ""
    var produtos: List<Produto> = emptyList()
    }
*/
