package br.com.edilsonvilarinho.androiddesafio.data.remote.datasource.user

import br.com.edilsonvilarinho.androiddesafio.data.model.User
import br.com.edilsonvilarinho.androiddesafio.data.remote.Network
import retrofit2.Response

class UserRemoteDataSourceImpl : UserRemoteDataSource {
    override suspend fun getUsers(): List<User> {
        return Network().userService.getUsers()
    }
}