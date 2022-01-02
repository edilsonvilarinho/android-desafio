package br.com.edilsonvilarinho.androiddesafio.data.remote

import br.com.edilsonvilarinho.androiddesafio.data.remote.api.user.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    val retrofitClient =
        Network.getRetrofitInstance("https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/")
    val userService = retrofitClient.create(UserService::class.java)
    companion object {
        fun getRetrofitInstance(path: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}