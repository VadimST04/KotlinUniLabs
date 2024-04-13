package com.example.myapp.events

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.MainActivity
import com.example.myapp.R
import com.example.myapp.SecondActivity
import com.example.myapp.ThirdActivity

class ButtonClickListener(private val activity: AppCompatActivity) : View.OnClickListener {
    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnNextA1, R.id.btnBackA3 -> {
                val intent = Intent(activity, SecondActivity::class.java)
                activity.startActivity(intent)
            }
            R.id.btnHomeA2, R.id.btnHomeA3, R.id.btnBackA2 -> {
                val intent = Intent(activity, MainActivity::class.java)
                activity.startActivity(intent)
            }
            R.id.btnNextA2 -> {
                val intent = Intent(activity, ThirdActivity::class.java)
                activity.startActivity(intent)
            }
            R.id.increaseTextButton -> {
                val textView = activity.findViewById<TextView>(R.id.textView4)
                val currentSize = textView.textSize / activity.resources.displayMetrics.scaledDensity // Конвертируем размер в sp
                if (currentSize < 40) {
                    val newSize = currentSize + 2
                    textView.textSize = newSize
                }
            }
        }
    }
}