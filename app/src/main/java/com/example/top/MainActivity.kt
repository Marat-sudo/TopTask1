package com.example.top

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val b: Button = findViewById(R.id.button)
        val quiz: Button = findViewById(R.id.quiz)
        val temp: Button = findViewById(R.id.temperature)
        val socialb: Button = findViewById(R.id.social)
        val calb: Button = findViewById(R.id.call)
        b.setOnClickListener {
            if (b.text == "top"){
                b.text = "RPO"
                b.setBackgroundColor(getColor(R.color.RPO))
            }
            else {
                b.text = "top"
                b.setBackgroundColor(getColor(R.color.purpleTop))
            }
        }

        quiz.setOnClickListener {
            val intent = Intent(this, Quiz::class.java)
            startActivity(intent)
        }

        temp.setOnClickListener {
            val intent = Intent(this, Temp::class.java)
            startActivity(intent)
        }

        socialb.setOnClickListener {
            val intent = Intent(this, Social::class.java)
            startActivity(intent)
        }

        calb.setOnClickListener {
            val intent = Intent(this, Call::class.java)
            startActivity(intent)
        }




    }
}