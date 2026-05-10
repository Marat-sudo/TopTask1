package com.example.top

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Temp : AppCompatActivity() {
    private lateinit var group: RadioGroup
    private lateinit var t: EditText
    private lateinit var  text: TextView

    private lateinit var b: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_temp)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        group = findViewById(R.id.radioGroup)
        t = findViewById(R.id.t)
        text = findViewById(R.id.text)
        b = findViewById(R.id.button)


        b.setOnClickListener {
            val rbId = group.checkedRadioButtonId

            if (rbId == -1) {
                text.text = "выберите что-то"
            }
            else {
                setContent(findViewById<RadioButton>(rbId))
            }

        }

    }
    private fun setContent(b: RadioButton)
    {
        val numStr: String = t.text
            .toString()
            .replace(',', '.')
            .trim()

        if (numStr == "") {
            text.text = "Ошибка, пустое поле"
        }

        val num: Double? =  numStr.toDoubleOrNull()

        if (num == null) {
            text.text = "Ошибка вводе"
            return
        }
        val n: Double =
            if (b.text.toString()[0] == 'F'){
            ftoC(num)
        } else {
            ctoF(num)
        }

        val nFormat = "%.2f".format(n)
        val str = "перевод ${b.text}: \n$num -> $nFormat"
        text.text = str

    }

    private fun ftoC(f: Double): Double
    {
        val c: Double = (f - 32) * 5/9

        return c
    }

    private fun ctoF(c: Double): Double
    {
        val f: Double = c * 9/5 + 32

        return f
    }
}