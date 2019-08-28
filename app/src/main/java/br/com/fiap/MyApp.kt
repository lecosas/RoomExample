package br.com.fiap

import android.app.Application
import br.com.fiap.di.dbModule
import br.com.fiap.di.repositoryModule
import br.com.fiap.di.uiModule
import br.com.fiap.di.viewModelModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {
    //Variaveis globais e injeção de dependências

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@MyApp)
            modules(
                listOf(
                    viewModelModule,
                    uiModule,
                    repositoryModule,
                    dbModule
                )
            )
        }
    }
}