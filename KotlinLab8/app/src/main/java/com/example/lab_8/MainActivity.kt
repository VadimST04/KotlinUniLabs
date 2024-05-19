package com.example.lab_8

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Vertical RecyclerView
        binding.recyclerViewVert.layoutManager = LinearLayoutManager(this)
        val phoneData = listOf(
            Pair("iPhone", "https://m.media-amazon.com/images/I/61bK6PMOC3L._AC_UF1000,1000_QL80_.jpg"),
            Pair("ASUS", "https://cdn.idealo.com/folder/Product/202120/1/202120171/s1_produktbild_max/asus-rog-phone-6d.jpg"),
            Pair("Xiaomi", "https://m.media-amazon.com/images/I/61Rb+Vyug9L._AC_UF894,1000_QL80_.jpg"),
            Pair("HTC", ""),
            Pair("Samsung", "https://m.media-amazon.com/images/I/715CyzOPwFL._AC_UF894,1000_QL80_.jpg"),
            Pair("LG", "https://www.lg.com/content/dam/channel/wcms/de/images/handy/lgh815_adeuvk_eedg_de_c/G4-thumbnail-large.jpg"),
            Pair("Nokia", "https://images.ctfassets.net/wcfotm6rrl7u/ddqlkk1B1HjBM9jMPbHqz/6e37788971804cbad6095622dcb03e73/nokia-G22-lagoon_blue-front_back-int.png"),
            Pair("Motorola", null),
        )
        val adapter = PhonesAdapter(phoneData){ position: Int ->
            Toast.makeText(this, phoneData[position].first, Toast.LENGTH_SHORT).show()
        }
        binding.recyclerViewVert.adapter = adapter

        // Horizontal RecyclerView
        binding.recyclerViewHor.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val textData = listOf(
            "iPhone",
            "ASUS",
            "Xiaomi",
            "HTC",
            "Samsung",
            "LG",
            "Nokia",
            "Motorola"
        )
        val adapterSecond = HorizontalViewAdapter(textData)
        binding.recyclerViewHor.adapter = adapterSecond

    }
}