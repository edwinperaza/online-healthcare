package com.moriahdp.app

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.moriahdp.app.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

const val URL_BASE_COVID_API = "BuildConfig.URL_BASE_API"

open class MoriahApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        AndroidThreeTen.init(this)
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MoriahApp)
            modules(listOf(appModule))
        }
    }
}
