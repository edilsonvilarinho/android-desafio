package br.com.edilsonvilarinho.androiddesafio.ui.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.edilsonvilarinho.androiddesafio.databinding.ActivityMainBinding
import br.com.edilsonvilarinho.androiddesafio.ui.view.main.adapter.RecyclerViewAdapter
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        initViews()
        observeViewModel()
        setContentView(binding.root)
    }

    private fun initViews() {
        adapter = RecyclerViewAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun observeViewModel() {
        mainViewModel.users.observe(this, {
            adapter.mUsers = it
        })
        mainViewModel.userListProgressBar.observe(this, {
            binding.userListProgressBar.isVisible = it
        })
        mainViewModel.error.observe(this, {
            it.message?.let { it1 -> Snackbar.make(binding.root, it1, Snackbar.LENGTH_LONG).show() }
        })
    }
}