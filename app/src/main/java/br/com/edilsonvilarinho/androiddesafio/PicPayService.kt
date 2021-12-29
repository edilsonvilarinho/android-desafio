package br.com.edilsonvilarinho.androiddesafio


import retrofit2.Call
import retrofit2.http.GET

interface PicPayService {
    @GET("users")
    fun getUsers(): Call<List<User>>
}