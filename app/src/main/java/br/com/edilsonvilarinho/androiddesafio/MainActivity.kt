package br.com.edilsonvilarinho.androiddesafio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.edilsonvilarinho.androiddesafio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}