package br.com.edilsonvilarinho.androiddesafio.data.repository

import android.content.Context
import br.com.edilsonvilarinho.androiddesafio.data.local.datasource.user.UserLocalDataSource
import br.com.edilsonvilarinho.androiddesafio.data.local.datasource.user.UserLocalDataSourceImpl
import br.com.edilsonvilarinho.androiddesafio.data.local.db.entity.toUser
import br.com.edilsonvilarinho.androiddesafio.data.model.User
import br.com.edilsonvilarinho.androiddesafio.data.model.toUserEntity
import br.com.edilsonvilarinho.androiddesafio.data.remote.datasource.user.UserRemoteDataSourceImpl

class UserRepositoryImpl(val context: Context) : UserRepository {

    private val userRemoteDataSource: UserLocalDataSource = UserLocalDataSourceImpl(context)


    override suspend fun getUsers(): List<User>? {
        val users: List<User> = UserRemoteDataSourceImpl().getUsers()
        userRemoteDataSource.insertUsers(users.map { it.toUserEntity() })
        return userRemoteDataSource.getUsers().map { it.toUser() }
    }

    override suspend fun getLocalUsers(): List<User>? {
        return userRemoteDataSource.getUsers().map { it.toUser() }
    }
}