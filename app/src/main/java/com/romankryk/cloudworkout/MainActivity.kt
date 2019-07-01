package com.romankryk.cloudworkout

import android.os.Bundle
import android.os.PersistableBundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.romankryk.cloudworkout.fragments.showToast
import ru.terrakok.cicerone.android.SupportFragmentNavigator
import ru.terrakok.cicerone.NavigatorHolder


class MainActivity : MvpAppCompatActivity() {
    //private var screensSchemeTV: TextView? = null
    //private val chain: List<WeakReference<Fragment>> = ArrayList()
    private lateinit var navigatorHolder: NavigatorHolder

    private val navigator = object : SupportFragmentNavigator(supportFragmentManager, R.id.my_nav_host_fragment) {

        override fun createFragment(screenKey: String?, data: Any?): android.support.v4.app.Fragment? {
            /*when(screenKey) {
                LIST_SCREEN -> return ListFragment.getNewInstance(data)
                DETAILS_SCREEN -> return DetailsSupportFragment.getNewInstance(data)
                else -> throw RuntimeException("Unknown screen key!")
            }*/
            return android.support.v4.app.Fragment()
        }

        override fun showSystemMessage(message: String) {
            showToast(message)
        }

        override fun exit() {
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)

        //auth.signOut();
        /*auth.signInWithEmailAndPassword("romankryk1803@gmail.com", "123456")
        .addOnCompleteListener(it -> {
            if (it.isSuccessful()) {
                Log.d(TAG, "SignUp successful");
            } else {
                Log.d(TAG, "SignUp failed", it.getException());
            }
        });*/
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}


