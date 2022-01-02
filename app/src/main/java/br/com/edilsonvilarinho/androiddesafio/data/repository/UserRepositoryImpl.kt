package br.com.edilsonvilarinho.androiddesafio.data.repository

import android.content.Context
import br.com.edilsonvilarinho.androiddesafio.data.local.db.UserDataBase
import br.com.edilsonvilarinho.androiddesafio.data.model.User
import br.com.edilsonvilarinho.androiddesafio.data.remote.datasource.user.UserRemoteDataSourceImpl

class UserRepositoryImpl(context: Context) : UserRepository {

    private val mUserDataBase: UserDataBase =
        UserDataBase.getInstance(context)

    override suspend fun getUsers(): List<User>? {
        val users: List<User> = UserRemoteDataSourceImpl().getUsers()
        users.forEach {
            mUserDataBase.save(it)
        }
        return mUserDataBase.getAll()
    }

    override suspend fun getLocalUsers(): List<User>? {
        return mUserDataBase.getAll()
    }
}