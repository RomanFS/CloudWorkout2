package com.romankryk.cloudworkout.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.romankryk.cloudworkout.R
import com.romankryk.cloudworkout.modules.User
import kotlinx.android.synthetic.main.sign_up.*
import java.util.*

class SignUp : Fragment(), View.OnClickListener, TextWatcher {
    private val TAG = "SignUp"

    private var auth = FirebaseAuth.getInstance()
    private var database = FirebaseDatabase.getInstance().reference
    private var nav = Navigation.findNavController(activity!!, R.id.my_nav_host_fragment)
    private var w = activity!!.window

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        w.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        w.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        return inflater.inflate(R.layout.sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt_finish_signup.isEnabled = false
        input_name.addTextChangedListener(this)
        input_email.addTextChangedListener(this)
        input_password.addTextChangedListener(this)
        input_reEnterPassword.addTextChangedListener(this)
        login.setOnClickListener(this)
        bt_finish_signup.setOnClickListener(this)
    }

    override fun afterTextChanged(s: Editable) {
        val name = input_name.text.toString()
        val email = input_email.text.toString()
        val password = input_password.text.toString()
        val repassword = input_reEnterPassword.text.toString()
        bt_finish_signup.isEnabled = validate(name, email, password, repassword)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.login -> {
                nav.popBackStack()
                nav.navigate(R.id.login)
            }
            R.id.bt_finish_signup -> finish()
        }
    }

    private fun finish() {
        val name = input_name.text.toString()
        val email = input_email.text.toString()
        val password = input_password.text.toString()
        val repassword = input_reEnterPassword.text.toString()
        if (validate(name, email, password, repassword)) {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    val user = User()
                    user.name = name
                    user.email = email
                    user.test = false
                    database.child("users").child(Objects.requireNonNull(it.result)!!.user.uid).setValue(user)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                auth.signInWithEmailAndPassword(email, password)
                                    .addOnCompleteListener { item ->
                                        if (item.isSuccessful) {
                                            Log.d(TAG, "SignUp successful")
                                            //nav.navigate(R.id.to_advice)

                                        } else {
                                            Log.d(TAG, "SignUp failed", item.exception)
                                        }
                                    }
                            }
                        }
                }
            }
        } else {
            Log.e(TAG, "validate = false")
        }
    }

    private fun validate(name: String, email: String, password: String, repassword: String): Boolean {

        // TODO: Write true validation, not this shit
        return name.isNotEmpty() &&
                email.isNotEmpty() &&
                password.isNotEmpty() &&
                repassword.isNotEmpty() &&
                password == repassword
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
        w.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

    }
}