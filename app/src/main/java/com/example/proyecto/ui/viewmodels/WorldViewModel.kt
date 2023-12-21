package com.example.proyecto.ui.viewmodels

import android.content.Context
import android.location.Location
import android.util.Patterns
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyecto.data.repositories.GetCurrentLocation


class WorldViewModel  : ViewModel() {

    private var _user = MutableLiveData("")
    val user: LiveData<String> = _user

    private var _password = MutableLiveData("")
    val password: LiveData<String> = _password

    private var _location = MutableLiveData("")
    val location: LiveData<String> = _location

    private var _destination = MutableLiveData("")
    val destination: LiveData<String> = _destination

    private var _divisa1 = MutableLiveData("")
    val divisa1: LiveData<String> = _divisa1

    private var _divisa2 = MutableLiveData("")
    val divisa2: LiveData<String> = _divisa2

    private var _deposito1 = MutableLiveData("")
    val deposito1: LiveData<String> = _deposito1

    private var _deposito2 = MutableLiveData("")
    val deposito2: LiveData<String> = _deposito2


    fun setLocation(location: String){
        _location.value = location
    }

    fun setUser(user: String) {
        _user.value = user
    }

    fun setPassword(password: String) {
        _password.value = password
    }

    fun setDestination(destination: String) {
        _destination.value = destination
    }

    fun setDivisa1(divisa1: String){
        _divisa1.value = divisa1
    }

    fun setDivisa2(divisa2: String){
        _divisa2.value = divisa2
    }

    fun setDeposito1(deposito1: String){
        _deposito1.value = deposito1
    }

    fun setDeposito2(deposito2: String){
        _deposito2.value = deposito2
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


    fun checkUser(): Boolean {
        if (checkUser() && checkUser()){return true}
        return false
    }


    fun returnInfoDestination(destination: String): Boolean {
        return destination == "Castellon"
    }

    fun returnDeposit(deposit: String): String{

        var operation = deposit
        operation = (deposit.toInt() * (1.07)).toString()
        return operation
    }

    @Composable
    fun LocationComponent(context: Context) {
        val currentLocation = remember { mutableStateOf<Location?>(null) }
        val cityName = remember { mutableStateOf<String?>(location.value) }
        _location.value = cityName.value.toString()
        GetCurrentLocation(context, currentLocation, cityName)
    }





}