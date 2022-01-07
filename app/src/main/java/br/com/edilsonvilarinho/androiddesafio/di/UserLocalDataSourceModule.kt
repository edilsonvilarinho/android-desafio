package br.com.edilsonvilarinho.androiddesafio.di

import br.com.edilsonvilarinho.androiddesafio.data.local.datasource.user.UserLocalDataSource
import br.com.edilsonvilarinho.androiddesafio.data.local.datasource.user.UserLocalDataSourceImpl
import org.koin.dsl.module

val userLocalDataSourceModule = module {

    single<UserLocalDataSource> { UserLocalDataSourceImpl(get()) }

}