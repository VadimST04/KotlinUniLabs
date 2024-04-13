package com.example.myapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.databinding.ActivityThirdBinding
import com.example.myapp.events.ButtonClickListener

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonClickListener = ButtonClickListener(this)
        binding.btnHomeA3.setOnClickListener(buttonClickListener)
        binding.btnBackA3.setOnClickListener(buttonClickListener)
        binding.increaseTextButton.setOnClickListener(buttonClickListener)
    }
}