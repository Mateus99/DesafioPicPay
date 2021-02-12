package com.example.desafiopicpay

import android.app.Application
import com.example.desafiopicpay.di.usersModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        //Inicializando o Koin
        startKoin {
            //Passando o contexto para o Koin (é sempre esse mesmo context?)
            androidContext(this@MyApp)

            //Declarando os módulos que foram criados
            modules(usersModule)
        }
    }

}