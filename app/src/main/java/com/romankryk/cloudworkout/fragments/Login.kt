package com.romankryk.cloudworkout.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.romankryk.cloudworkout.R
import kotlinx.android.synthetic.main.login.*
import java.util.*

class Login(contentLayoutId: Int) : Fragment(contentLayoutId), View.OnClickListener, TextWatcher {
    private val TAG = "Login"
    private var auth = FirebaseAuth.getInstance()
    //private var nav = Navigation.findNavController(activity!!, R.id.my_nav_host_fragment)
    private var database = FirebaseDatabase.getInstance().reference
    private var w = activity!!.window

    private var test = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        w!!.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        w!!.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        return inflater.inflate(R.layout.login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_login.isEnabled = false
        input_email.addTextChangedListener(this)
        input_password.addTextChangedListener(this)
        link_signup.setOnClickListener(this)
        btn_login.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.link_signup -> {
                //nav.popBackStack()
                //nav.navigate(R.id.signUp)
            }
            R.id.btn_login -> login()
        }
    }

    private fun login() {
        val email = input_email!!.text.toString()
        val password = input_password!!.text.toString()
        if (validate(email, password)) {
            auth!!.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.d(TAG, "SignUp successful")
                    val mostafa = database.child("users").child(auth.uid!!).child("test")

                    mostafa.addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            test = dataSnapshot.getValue(Boolean::class.java)!!

                            if (Objects.requireNonNull(test)) {
                                //nav.navigate(R.id.to_dashboard_frag)
                            } else {
                                //nav.navigate(R.id.to_advice)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {

                        }
                    })
                } else {
                    Toast.makeText(context, "Wrong password or email", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(context, "Enter your email or password please", Toast.LENGTH_SHORT).show()
        }
    }

    override fun afterTextChanged(s: Editable) {
        btn_login!!.isEnabled = validate(input_email!!.text.toString(), input_password!!.text.toString())
    }

    private fun validate(email: String, password: String): Boolean {
        return email.isNotEmpty() && password.isNotEmpty()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
        w!!.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
}