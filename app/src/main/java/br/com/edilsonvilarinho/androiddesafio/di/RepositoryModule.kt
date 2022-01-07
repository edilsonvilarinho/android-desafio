package br.com.edilsonvilarinho.androiddesafio.di

import br.com.edilsonvilarinho.androiddesafio.data.repository.UserRepository
import br.com.edilsonvilarinho.androiddesafio.data.repository.UserRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    single<UserRepository> { UserRepositoryImpl(get(), get()) }

}