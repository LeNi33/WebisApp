package com.example.webisapp.viewmodel

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    fun validateUser(user: String, pass: String): Boolean {
        return user == "admin" && pass == "1234"
    }
}
