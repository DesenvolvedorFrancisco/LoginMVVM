package dev.francisco.loginmvvm

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dev.francisco.loginmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.login().observe(this, Observer {
                Toast.makeText(applicationContext,it, Toast.LENGTH_SHORT).show()
        })

        binding.buttonEntrar.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val pass = binding.editPassword.text.toString()

            viewModel.doLogin(email,pass)
        }
    }
}