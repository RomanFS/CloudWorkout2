package com.romankryk.cloudworkout

import androidx.fragment.app.Fragment
import com.romankryk.cloudworkout.fragments.Welcome
import ru.terrakok.cicerone.android.support.SupportAppScreen



class Screens {
    class SampleScreen(private val number: Int) : SupportAppScreen() {

        init {
            this.screenKey = javaClass.simpleName + "_" + number
        }

        override fun getFragment(): Fragment {
            return Welcome.getNewInstance(number)
        }
    }
}
