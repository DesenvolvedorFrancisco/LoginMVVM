package dev.francisco.loginmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val personRepository = PersonRepository()
    private var login = MutableLiveData<String>()


    fun login(): LiveData<String> {
        return login
    }

    fun doLogin(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()){
            login.value = "Campos vazios";
        }else if (personRepository.login(email, password)) {
            login.value = "Login OK"
        }else {
            login.value = "Login Error"
        }

    }
}