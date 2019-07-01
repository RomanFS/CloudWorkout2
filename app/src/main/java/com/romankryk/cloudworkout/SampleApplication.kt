package com.romankryk.cloudworkout

import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Cicerone
import android.app.Application


class SampleApplication : Application() {
    lateinit var INSTANCE: SampleApplication
    private lateinit var cicerone: Cicerone<Router>

    val navigatorHolder: NavigatorHolder
        get() = cicerone.navigatorHolder

    val router: Router
        get() = cicerone.router

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        cicerone = Cicerone.create()
    }
}