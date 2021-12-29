package br.com.edilsonvilarinho.androiddesafio

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private var mUsers = MutableLiveData<List<User>>()
    var users = mUsers
    private var mUserListProgressBar = MutableLiveData<Boolean>().apply {
        this.value = true
    }
    var userListProgressBar = mUserListProgressBar

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
                } else {
                    mUsers.value = ArrayList()
                }
                mUserListProgressBar.value = false
            }
        })

    }

}