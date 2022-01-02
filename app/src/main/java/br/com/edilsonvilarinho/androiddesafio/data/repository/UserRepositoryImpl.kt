package br.com.edilsonvilarinho.androiddesafio.data.repository

import android.content.Context
import br.com.edilsonvilarinho.androiddesafio.data.local.datasource.user.UserLocalDataSource
import br.com.edilsonvilarinho.androiddesafio.data.local.datasource.user.UserLocalDataSourceImpl
import br.com.edilsonvilarinho.androiddesafio.data.local.db.entity.toUser
import br.com.edilsonvilarinho.androiddesafio.data.model.User
import br.com.edilsonvilarinho.androiddesafio.data.model.toUserEntity
import br.com.edilsonvilarinho.androiddesafio.data.remote.datasource.user.UserRemoteDataSource
import br.com.edilsonvilarinho.androiddesafio.data.remote.datasource.user.UserRemoteDataSourceImpl

class UserRepositoryImpl(
    context: Context,
    val userRemoteDataSource: UserRemoteDataSource = UserRemoteDataSourceImpl(),
    val userLocalDataSource: UserLocalDataSource = UserLocalDataSourceImpl(context)
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