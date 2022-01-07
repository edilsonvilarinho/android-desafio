package br.com.edilsonvilarinho.androiddesafio.data.repository

import br.com.edilsonvilarinho.androiddesafio.data.local.datasource.user.UserLocalDataSource
import br.com.edilsonvilarinho.androiddesafio.data.local.db.entity.toUser
import br.com.edilsonvilarinho.androiddesafio.data.model.User
import br.com.edilsonvilarinho.androiddesafio.data.model.toUserEntity
import br.com.edilsonvilarinho.androiddesafio.data.remote.datasource.user.UserRemoteDataSource

class UserRepositoryImpl(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userLocalDataSource: UserLocalDataSource
) : UserRepository {
    override suspend fun getUsers(): List<User>? {
        val users: List<User> = userRemoteDataSource.getUsers()
        userLocalDataSource.insertUsers(users.map { it.toUserEntity() })
        return userLocalDataSource.getUsers().map { it.toUser() }
    }

    override suspend fun getLocalUsers(): List<User>? {
        return userLocalDataSource.getUsers().map { it.toUser() }
    }
}