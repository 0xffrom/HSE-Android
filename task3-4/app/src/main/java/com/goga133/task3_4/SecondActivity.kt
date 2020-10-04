package com.goga133.task3_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        button_back.setOnClickListener {
            onBackPressed();
        }
    }

    override fun onStart() {
        super.onStart()
        textView_saved.text = intent.extras?.getString("editText") ?: "Ошибка";
    }
}