package br.com.edilsonvilarinho.androiddesafio.data.local.datasource.user

import br.com.edilsonvilarinho.androiddesafio.data.model.User

interface UserLocalDataSource {
    fun getUsers(): List<User>
    fun insertUsers(userList: List<User>)
}