package br.com.edilsonvilarinho.androiddesafio


import retrofit2.Call
import retrofit2.http.GET

interface Recurso {
    @GET("users")
    fun pegarUsuarios(): Call<List<Usuario>>
}