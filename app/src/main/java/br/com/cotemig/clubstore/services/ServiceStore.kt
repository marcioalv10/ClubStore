package br.com.cotemig.clubstore.services

import br.com.cotemig.clubstore.model.Store
import retrofit2.Call
import retrofit2.http.GET

interface ServiceStore {

    @GET("be66019e-d675-4d00-8f41-138b292c4a25")
    fun getStores(): Call<List<Store>>
}