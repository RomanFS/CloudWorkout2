package com.romankryk.cloudworkout

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.commands.Command


class MainActivity(val router: RouterSample) : AppCompatActivity() {


    private val navigator = Navigator { }

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
        router.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        router.removeNavigator()
    }
}


