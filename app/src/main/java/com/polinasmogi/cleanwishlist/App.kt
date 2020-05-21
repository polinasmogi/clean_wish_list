package com.polinasmogi.cleanwishlist

import android.app.Application
import com.polinasmogi.cleanwishlist.data.di.dataModules
import com.polinasmogi.cleanwishlist.domain.di.domainModules
import com.polinasmogi.cleanwishlist.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(presentationModule + domainModules + dataModules)
        }
    }

}