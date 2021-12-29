package br.com.edilsonvilarinho.androiddesafio

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.edilsonvilarinho.androiddesafio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.obterContatos()
        mainViewModel.contatos.observe(this, {
            binding.userListProgressBar.visibility = View.GONE
            var adapter = RecyclerViewAdapter(it)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
        })
        binding.userListProgressBar.visibility = View.VISIBLE
        setContentView(binding.root)
    }
}