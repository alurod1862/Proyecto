package com.example.pmdm_login.logic

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel  : ViewModel() {



    private var _user = MutableLiveData("")

    val user: LiveData<String> = _user


    private var _password = MutableLiveData("")

    val password: LiveData<String> = _password


    fun setUser(user: String) {
        _user.value = user
    }

    fun setPassword(password: String) {
        _password.value = password
    }

    fun checkPassword(): Boolean {
            val password = _password.value
            if (password != null) {
                return password.length > 6
            }
        return false
    }


    fun checkEmail(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(_user.value).matches()
    }

}