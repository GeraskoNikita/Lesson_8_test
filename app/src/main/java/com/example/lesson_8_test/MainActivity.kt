package com.example.lesson_8_test

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lesson_8_test.data.Pref
import com.example.lesson_8_test.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var db: Pref
    private lateinit var bining: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bining = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bining.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        db = Pref(this)
        bining.tvValue.text = db.getPrev().toString()
        swichButtonText()

        bining.btSave.setOnClickListener {
            var value = if (bining.btSave.text == "+") db.getPrev() + 1 else db.getPrev() - 1
            db.savePrev(value)
            bining.tvValue.text = db.getPrev().toString()
            swichButtonText()


        }


    }

    private fun swichButtonText() {
        if (bining.tvValue.text.toString().toInt() <= 0) {
            bining.btSave.text = "+"
        } else if (bining.tvValue.text.toString().toInt() >= 10) {
            bining.btSave.text = "-"
        }
    }
}