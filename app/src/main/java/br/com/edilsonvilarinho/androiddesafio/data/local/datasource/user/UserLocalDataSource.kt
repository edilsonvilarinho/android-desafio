package br.com.edilsonvilarinho.androiddesafio.data.local.datasource.user

import br.com.edilsonvilarinho.androiddesafio.data.local.db.entity.UserEntity

interface UserLocalDataSource {
    suspend fun getUsers(): List<UserEntity>
    suspend fun insertUsers(userList: List<UserEntity>)
}