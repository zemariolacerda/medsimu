package com.lpz.medsimu

import android.app.Application
import com.lpz.medsimu.data.di.DataModule
import com.lpz.medsimu.domain.di.DomainModule
import com.lpz.medsimu.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()
        DomainModule.load()
        PresentationModule.load()
    }
}