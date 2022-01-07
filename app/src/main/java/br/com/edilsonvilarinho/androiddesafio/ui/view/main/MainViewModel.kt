package br.com.edilsonvilarinho.androiddesafio.ui.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.edilsonvilarinho.androiddesafio.data.model.User
import br.com.edilsonvilarinho.androiddesafio.data.repository.UserRepository
import kotlinx.coroutines.launch

class MainViewModel( private val repository: UserRepository ) : ViewModel() {

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
                repository.getUsers()?.let {
                    mUsers.value = it
                }
            } catch (e: Exception) {
                mError.value = e
                mUsers.value = repository.getLocalUsers()
            } finally {
                mUserListProgressBar.value = false
            }
        }
    }
}