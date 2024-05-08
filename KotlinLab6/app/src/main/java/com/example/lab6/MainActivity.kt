package com.example.lab6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val userParam = intent.getParcelableExtra<User>("person")
        if (userParam != null) {
            binding.nameText.setText(user.name)
            binding.ageText.setText(user.age)
        }

        user = User("name", 123)
        binding.button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("person", User(binding.nameText.text.toString(), binding.ageText.text.toString().toInt()))
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("person", user)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        user = savedInstanceState.getParcelable("person")!!
    }
}