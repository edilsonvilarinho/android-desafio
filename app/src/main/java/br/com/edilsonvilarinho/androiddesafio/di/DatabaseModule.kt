package br.com.edilsonvilarinho.androiddesafio.di

import br.com.edilsonvilarinho.androiddesafio.data.local.db.AppDatabase
import br.com.edilsonvilarinho.androiddesafio.data.local.db.AppDatabase.Companion.getDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single { get<AppDatabase>().userDao() }

    single { getDatabase(context = androidContext()) }


}