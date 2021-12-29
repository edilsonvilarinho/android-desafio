package br.com.edilsonvilarinho.androiddesafio

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private var mContatos = MutableLiveData<List<Usuario>>()
    var contatos = mContatos

    fun obterContatos() {

        val retrofitClient =
            RedeUtils.getRetrofitInstance("https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/")

        val recurso = retrofitClient.create(Recurso::class.java)

        val retorno = recurso.pegarUsuarios()

        retorno.enqueue(object : Callback<List<Usuario>> {
            override fun onFailure(call: Call<List<Usuario>>, t: Throwable) {
                mContatos.value = ArrayList()
            }

            override fun onResponse(call: Call<List<Usuario>>, response: Response<List<Usuario>>) {
                if (response.code() == 200) {
                    mContatos.value = response.body()
                } else {
                    mContatos.value = ArrayList()
                }
            }
        })

    }

}