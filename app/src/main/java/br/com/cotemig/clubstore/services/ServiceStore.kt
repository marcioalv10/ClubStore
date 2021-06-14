package br.com.cotemig.clubstore.services

import br.com.cotemig.clubstore.model.Store
import retrofit2.Call
import retrofit2.http.GET

interface ServiceStore {

    @GET("514668fc-08a7-49e4-b07b-57dc392af692")
    fun getStores(): Call<List<Store>>
}