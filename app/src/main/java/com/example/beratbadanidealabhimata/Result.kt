package com.example.beratbadanidealabhimata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity


class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val intent = getIntent()

        val name = intent.getStringExtra("Ideal")

        text_result.text = name

        btn_back.onClick {
            startActivity<MainActivity>()
        }

    }
}