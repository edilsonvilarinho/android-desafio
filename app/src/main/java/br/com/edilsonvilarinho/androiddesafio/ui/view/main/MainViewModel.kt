package br.com.edilsonvilarinho.androiddesafio.ui.view.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.edilsonvilarinho.androiddesafio.data.Network
import br.com.edilsonvilarinho.androiddesafio.domain.User
import br.com.edilsonvilarinho.androiddesafio.data.UserRepository
import br.com.edilsonvilarinho.androiddesafio.data.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var mUsers = MutableLiveData<List<User>>()
    var users = mUsers
    private var mUserListProgressBar = MutableLiveData<Boolean>().apply {
        this.value = true
    }
    var userListProgressBar = mUserListProgressBar

    private val mUserRepository: UserRepository =
        UserRepository.getInstance(application.applicationContext)

    fun getUsers() {
        val retrofitClient =
            Network.getRetrofitInstance("https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/")
        val userService = retrofitClient.create(UserService::class.java)
        val callback = userService.getUsers()
        callback.enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                mUsers.value = ArrayList()
                mUserListProgressBar.value = false
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.code() == 200) {
                    mUsers.value = response.body()
                    persistUsers()
                } else {
                    mUsers.value = ArrayList()
                }
                mUserListProgressBar.value = false
            }
        })
    }

    private fun persistUsers() {
        if (mUserRepository.getAll()?.isEmpty() == true) {
            mUsers.value?.forEach {
                mUserRepository.save(it)
            }
        } else {
            Log.i("persistUsers: ", mUserRepository.getAll()?.size.toString())
        }
    }

}