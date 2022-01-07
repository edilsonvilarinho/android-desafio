package br.com.edilsonvilarinho.androiddesafio.di

import br.com.edilsonvilarinho.androiddesafio.ui.view.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainViewModel(get()) }

}