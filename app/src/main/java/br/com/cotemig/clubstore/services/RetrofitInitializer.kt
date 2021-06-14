package br.com.cotemig.clubstore.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder().baseUrl("https://api.fluo.work/v1/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    //Variavel para carregar os dados da api Mock
    private val retrofitp = Retrofit.Builder().baseUrl("https://run.mocky.io/v3/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun serviceStore(): ServiceStore {
        return retrofitp.create(ServiceStore::class.java)
    }


    fun serviceAccount(): ServiceAccount {

        return retrofit.create(ServiceAccount::class.java)
    }


}