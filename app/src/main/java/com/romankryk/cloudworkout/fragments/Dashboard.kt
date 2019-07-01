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
import kotlinx.android.synthetic.main.dashboard.*

class Dashboard : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //avatar.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.to_profile))

        val navBar = activity!!.findViewById<BottomNavigationItemView>(R.id.nav_bar)
        val params = navBar.layoutParams as RelativeLayout.LayoutParams
        params.height = RelativeLayout.LayoutParams.WRAP_CONTENT
        navBar.layoutParams = params
    }
}