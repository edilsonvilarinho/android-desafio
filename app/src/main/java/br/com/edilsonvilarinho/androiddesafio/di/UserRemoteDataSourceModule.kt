package br.com.edilsonvilarinho.androiddesafio.di

import br.com.edilsonvilarinho.androiddesafio.data.remote.datasource.user.UserRemoteDataSource
import br.com.edilsonvilarinho.androiddesafio.data.remote.datasource.user.UserRemoteDataSourceImpl
import org.koin.dsl.module

val userRemoteDataSourceModule = module {

    single<UserRemoteDataSource> { UserRemoteDataSourceImpl() }

}