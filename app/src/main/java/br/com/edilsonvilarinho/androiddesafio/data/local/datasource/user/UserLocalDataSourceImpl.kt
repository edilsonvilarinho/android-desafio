package br.com.edilsonvilarinho.androiddesafio.data.local.datasource.user

import br.com.edilsonvilarinho.androiddesafio.data.local.db.UserDao
import br.com.edilsonvilarinho.androiddesafio.data.local.db.entity.UserEntity

class UserLocalDataSourceImpl(private val userDao: UserDao) : UserLocalDataSource {

    override suspend fun getUsers(): List<UserEntity> {
        return userDao.getUsers()
    }

    override suspend fun insertUsers(userList: List<UserEntity>) {
        userList.forEach {
            userDao.insert(it)
        }
    }

}