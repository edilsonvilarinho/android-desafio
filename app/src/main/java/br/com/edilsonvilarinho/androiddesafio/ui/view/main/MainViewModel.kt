package br.com.edilsonvilarinho.androiddesafio.ui.view.main

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import br.com.edilsonvilarinho.androiddesafio.data.remote.Network
import br.com.edilsonvilarinho.androiddesafio.data.model.User
import br.com.edilsonvilarinho.androiddesafio.data.local.db.UserDataBase
import br.com.edilsonvilarinho.androiddesafio.data.remote.api.user.UserService
import br.com.edilsonvilarinho.androiddesafio.data.repository.UserRepository
import br.com.edilsonvilarinho.androiddesafio.data.repository.UserRepositoryImpl
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(val app: Application) : AndroidViewModel(app) {

    private val mUsers = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = mUsers
    private val mUserListProgressBar = MutableLiveData<Boolean>()
    val userListProgressBar: LiveData<Boolean> = mUserListProgressBar
    private val mError = MutableLiveData<Exception>()
    val error: LiveData<Exception> = mError

    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            try {
                mUserListProgressBar.value = true
                UserRepositoryImpl(app).getUsers()?.let {
                    mUsers.value = it
                }
            } catch (e: Exception) {
                mError.value = e
                mUsers.value = UserRepositoryImpl(app).users
            } finally {
                mUserListProgressBar.value = false
            }
        }
    }
}