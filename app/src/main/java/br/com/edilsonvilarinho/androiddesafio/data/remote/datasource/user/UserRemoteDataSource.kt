package br.com.edilsonvilarinho.androiddesafio.data.remote.datasource.user

import br.com.edilsonvilarinho.androiddesafio.data.model.User
import retrofit2.Response

interface UserRemoteDataSource {
   suspend fun getUsers(): List<User>
}