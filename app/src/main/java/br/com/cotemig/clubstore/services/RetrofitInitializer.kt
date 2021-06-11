package br.com.cotemig.clubstore.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder().baseUrl("https://api.fluo.work/v1/")
        .addConverterFactory(GsonConverterFactory.create()).build()



    fun serviceAccount(): ServiceAccount{

        return retrofit.create(ServiceAccount::class.java)
    }


}