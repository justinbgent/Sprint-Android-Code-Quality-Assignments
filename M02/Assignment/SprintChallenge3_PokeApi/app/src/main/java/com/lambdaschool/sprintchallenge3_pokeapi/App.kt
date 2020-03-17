package com.lambdaschool.sprintchallenge3_pokeapi

import android.app.Application
import com.facebook.stetho.Stetho

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)
    }
}