package com.romankryk.cloudworkout.fragments.start

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.romankryk.cloudworkout.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class Start1 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.start1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val next = view.findViewById<Button>(R.id.next)
        val back = view.findViewById<Button>(R.id.next)

        next.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.next))
        back.setOnClickListener { activity!!.onBackPressed() }
    }
}

class Start2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.start2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val next = view.findViewById<Button>(R.id.next)
        val back = view.findViewById<Button>(R.id.next)

        next.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.next))
        back.setOnClickListener { activity!!.onBackPressed() }
    }
}

class Start3 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.start3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val next = view.findViewById<Button>(R.id.next)
        val back = view.findViewById<Button>(R.id.next)

        next.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.next))
        back.setOnClickListener { activity!!.onBackPressed() }
    }
}

class Start4 : Fragment() {
    private val TAG = "Start4"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.start4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val next = view.findViewById<Button>(R.id.next)
        val back = view.findViewById<Button>(R.id.next)

        next.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.next))
        back.setOnClickListener { activity!!.onBackPressed() }

        initRecyclerView(view)
    }

    private fun initRecyclerView(view: View) {
        Log.d(TAG, "initRecyclerView: init recyclerview.")
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_num)
        val adapter = WeightAdapter(view)
        adapter.setSize(40)

        recyclerView.setAdapter(adapter)
        recyclerView.setLayoutManager(LinearLayoutManager(context))
    }
}

class Start5 : Fragment() {
    private val TAG = "Start5"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.start5, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val next = view.findViewById<Button>(R.id.next)
        val back = view.findViewById<Button>(R.id.next)

        next.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.next))
        back.setOnClickListener { activity!!.onBackPressed() }

        initRecyclerView(view)

        val auth = FirebaseAuth.getInstance()
        val database = FirebaseDatabase.getInstance().reference
        val mostafa = database.child("users").child(auth.uid!!).child("test")

        next.setOnClickListener {
            mostafa.setValue(true)
            Navigation.findNavController(activity!!, R.id.my_nav_host_fragment)
                .navigate(R.id.next)
        }
    }

    private fun initRecyclerView(view: View) {
        Log.d(TAG, "initRecyclerView: init recyclerview.")
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_num)
        recyclerView.setLayoutManager(LinearLayoutManager(context))
        val adapter = HeightAdapter(view)
        adapter.setSize(145)
        recyclerView.setAdapter(adapter)
    }
}

