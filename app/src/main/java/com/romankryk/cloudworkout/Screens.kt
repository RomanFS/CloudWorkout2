package com.romankryk.cloudworkout

import androidx.fragment.app.Fragment
import com.romankryk.cloudworkout.fragments.Welcome
import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.android.support.SupportAppScreen



class Screens {
    public val main = object: Screen() {
    }

    fun doit(){
        main.screenKey
    }
}
