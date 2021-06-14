package br.com.cotemig.clubstore.model

import java.io.Serializable

/*
class Produto {
    var item: String = ""
    var image: String = ""
}*/

data class Produto (

    var item: String = "",
    var image: String = "",
    var preco: Double = 0.0

): Serializable