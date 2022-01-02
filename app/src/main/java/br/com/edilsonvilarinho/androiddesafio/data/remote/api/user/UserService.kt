package br.com.edilsonvilarinho.androiddesafio.data.remote.api.user


import br.com.edilsonvilarinho.androiddesafio.data.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    @GET("users")
    suspend fun getUsers(): List<User>
}