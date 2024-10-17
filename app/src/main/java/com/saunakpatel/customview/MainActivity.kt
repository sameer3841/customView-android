package com.saunakpatel.customview

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var myView1: MyView1;
    lateinit var checker: CheckBox;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        myView1 = findViewById(R.id.myView1)
        checker = findViewById(R.id.checker)

        myView1.drawCircle = false

        checker.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) myView1.drawCircle = true
            else myView1.drawCircle = false
            myView1.invalidate()
        }
    }
}
