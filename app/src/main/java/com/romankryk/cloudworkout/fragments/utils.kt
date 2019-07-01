package com.romankryk.cloudworkout.fragments

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import com.google.firebase.auth.FirebaseAuth
import com.romankryk.cloudworkout.R

class utils {
}


fun Context.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}