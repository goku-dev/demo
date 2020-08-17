package com.techja.demokotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    val TAG: String = MainActivity::class.java.name;
    var text: String = ""

    val demo = Demo()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        initView()


        findViewById<Button>(R.id.test_button).setOnClickListener {
            demo.start()
        }
    }
}