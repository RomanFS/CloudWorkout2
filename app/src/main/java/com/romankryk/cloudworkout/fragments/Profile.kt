package com.romankryk.cloudworkout.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.romankryk.cloudworkout.R
import com.romankryk.cloudworkout.modules.User
import kotlinx.android.synthetic.main.profile.*
import java.util.*

class Profile : Fragment(), View.OnClickListener {
    private val TAG = "Profile"
    private var auth = FirebaseAuth.getInstance()
    private var nav = Navigation.findNavController(activity!!, R.id.my_nav_host_fragment)
    var num = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        val database = FirebaseDatabase.getInstance().reference
        database.child("users").child(auth.currentUser!!.uid)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(data: DataSnapshot) {
                    val user = data.getValue(User::class.java)
                    full_name.setText(user!!.name, TextView.BufferType.EDITABLE)
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    Log.e(TAG, "onCancelled: ", databaseError.toException())
                }
            })

        activity!!.findViewById<Button>(R.id.dashboard_bt)
            .setOnClickListener { nav.popBackStack() }
        back.setOnClickListener { activity!!.onBackPressed() }
        acc_set.setOnClickListener(this)
        edit_profile.setOnClickListener(this)
        invite.setOnClickListener(this)
        signOut.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        /*when (v.id) {
            R.id.signOut -> {
                Log.d(TAG, "signOut")
                auth.signOut()
                nav.navigate(R.id.to_welcome)
            }
            R.id.acc_set -> nav.navigate(R.id.to_nowInDevelopment)
            R.id.calendar_bt -> nav.navigate(R.id.to_nowInDevelopment)
            R.id.checklist_bt -> nav.navigate(R.id.to_nowInDevelopment)
            else -> Log.e(TAG, "Unknown button clicked")
        }*/
    }

    override fun onPause() {
        super.onPause()
        num = false
    }
}