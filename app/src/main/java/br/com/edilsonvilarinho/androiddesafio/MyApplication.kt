package br.com.edilsonvilarinho.androiddesafio

import android.app.Application
import br.com.edilsonvilarinho.androiddesafio.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApplication : Application() {

    private val modules = listOf(
        repositoryModule,
        databaseModule,
        viewModelModule,
        userRemoteDataSourceModule,
        userLocalDataSourceModule
    )

    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@MyApplication)
            // declare modules
            modules(modules)
        }
    }
}