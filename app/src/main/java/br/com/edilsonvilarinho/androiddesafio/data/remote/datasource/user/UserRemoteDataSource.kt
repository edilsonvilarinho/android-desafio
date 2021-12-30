package br.com.edilsonvilarinho.androiddesafio.data.remote.datasource.user

import br.com.edilsonvilarinho.androiddesafio.data.model.User

interface UserRemoteDataSource {
    fun getUsers(): List<User>
}