package br.com.cotemig.clubstore.services

import br.com.cotemig.clubstore.model.Store
import retrofit2.Call
import retrofit2.http.GET

interface ServiceStore {

    @GET("e1d39c36-4574-4267-9a2b-86f45614c7c7")
    fun getStores(): Call<List<Store>>
}