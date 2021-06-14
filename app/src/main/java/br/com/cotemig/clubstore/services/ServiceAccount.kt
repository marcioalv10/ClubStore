package br.com.cotemig.clubstore.services


import br.com.cotemig.clubstore.model.Account
import br.com.cotemig.clubstore.model.Store
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceAccount {






    @POST("account")
       fun create(@Body account: Account): Call<Account>

    @POST("account/forgot")
    fun forgot(@Body account: Account) : Call<Void>
    //para os casos que a API não retornar nenhum json utilize Void


    @POST("account/auth")
    fun auth(@Body account: Account) : Call<Account>


}