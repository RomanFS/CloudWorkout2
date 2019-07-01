package com.romankryk.cloudworkout

import ru.terrakok.cicerone.BaseRouter
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.commands.BackTo
import ru.terrakok.cicerone.commands.Forward

class RouterSample : BaseRouter(){
    private var navigator: Navigator? = null

    fun setNavigator(navigator: Navigator) {
        this.navigator = navigator
    }

    fun removeNavigator() {
        this.navigator = null
    }

    fun newRootScreenWithMessage(screenKey: String, data: Any?, message: String){
        if (navigator != null) {
            navigator!!.applyCommands(arrayOf(BackTo(null)))
            navigator!!.applyCommands(arrayOf(Forward('')))
        }
    }
}