package br.com.edilsonvilarinho.androiddesafio.data.local.datasource.user

import android.content.Context
import br.com.edilsonvilarinho.androiddesafio.data.local.db.UserDataBase
import br.com.edilsonvilarinho.androiddesafio.data.model.User

class UserLocalDataSourceImpl(context: Context) : UserLocalDataSource {

    private val mUserDataBase: UserDataBase =
        UserDataBase.getInstance(context)

    override fun getUsers(): List<User> {
        return mUserDataBase.getAll()!!
    }

    override fun insertUsers(userList: List<User>) {
        if (mUserDataBase.getAll()!!.isNotEmpty()) {
            userList.forEach {
                mUserDataBase.delete(it.id)
            }
        }
        userList.forEach {
            mUserDataBase.save(it)
        }
    }
}