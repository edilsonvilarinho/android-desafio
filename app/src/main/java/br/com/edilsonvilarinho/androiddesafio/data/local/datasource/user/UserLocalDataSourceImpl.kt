package br.com.edilsonvilarinho.androiddesafio.data.local.datasource.user

import android.content.Context
import br.com.edilsonvilarinho.androiddesafio.data.local.db.AppDatabase
import br.com.edilsonvilarinho.androiddesafio.data.local.db.entity.UserEntity

class UserLocalDataSourceImpl(context: Context) : UserLocalDataSource {

    private val database = AppDatabase.getDatabase(context)

    override suspend fun getUsers(): List<UserEntity> {
        return database.userDao().getUsers()
    }

    override suspend fun insertUsers(userList: List<UserEntity>) {
        userList.forEach {
            database.userDao().insert(it)
        }
    }

}