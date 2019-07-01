package com.romankryk.cloudworkout.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.romankryk.cloudworkout.R
import kotlinx.android.synthetic.main.advice.*

class Advice : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.advice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //start.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.start))
        //welcome_frag.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.to_dashboard_frag))
    }
}