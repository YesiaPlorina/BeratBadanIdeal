package com.example.beratbadanidealabhimata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_result_wanita.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class resultWanita : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_wanita)

        val intent = getIntent()

        val name = intent.getStringExtra("Ideal")

        text_result_wanita.text = name

        btn_back_wanita.onClick {
            startActivity<MainActivity>()
        }


    }
}