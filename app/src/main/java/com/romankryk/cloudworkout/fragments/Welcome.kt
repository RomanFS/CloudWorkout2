package com.romankryk.cloudworkout.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.romankryk.cloudworkout.R
import kotlinx.android.synthetic.main.welcome.*

class Welcome : Fragment() {
    //private var navController = Navigation.findNavController(activity!!, R.id.my_nav_host_fragment)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navView = activity!!.findViewById<View>(R.id.nav_bar)
        val params = navView.layoutParams as RelativeLayout.LayoutParams
        params.height = 0
        navView.layoutParams = params

        //signUp.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.signUp))
        //signIn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.login))
    }

    companion object {
        private val TAG = "Welcome"
    }
}