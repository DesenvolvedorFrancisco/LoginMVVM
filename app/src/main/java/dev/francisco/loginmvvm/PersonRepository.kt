package dev.francisco.loginmvvm

class PersonRepository {

    fun login(email: String, password: String): Boolean {
        return (email == "admin" && password == "pass")
    }
}