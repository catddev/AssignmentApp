package com.junodev.assignmentapp

import android.app.Application
import com.junodev.assignmentapp.di.DI

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DI.initDI(this@App)
    }
}
