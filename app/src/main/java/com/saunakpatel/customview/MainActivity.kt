package com.saunakpatel.customview

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var myView1: MyView1;
    private lateinit var checker: CheckBox;
    private lateinit var pos: SeekBar;
    private lateinit var rad: SeekBar;
    private lateinit var colorGroup: RadioGroup;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        myView1 = findViewById(R.id.myView1)
        checker = findViewById(R.id.checker)
        pos = findViewById(R.id.pos)
        rad = findViewById(R.id.rad)
        colorGroup = findViewById(R.id.colorGroup)

        myView1.drawCircle = false

        checker.setOnCheckedChangeListener { _, isChecked ->
            myView1.drawCircle = isChecked
            myView1.invalidate()
        }

        colorGroup.setOnCheckedChangeListener { _, _ -> update() }


        pos.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val maxProgress = seekBar?.max ?: 100
                val screenWidth = resources.displayMetrics.widthPixels
                val circleRadius = myView1.circleRad

                var newX = (progress.toFloat() / maxProgress) * (screenWidth - 2 * circleRadius)

                if (progress == pos.min || newX < circleRadius) {
                    newX = circleRadius
                } else if (newX + circleRadius > screenWidth - circleRadius || progress == pos.max) {
                    newX = screenWidth - circleRadius
                }

                myView1.circleX = newX
                myView1.invalidate()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        rad.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val newRadius = 10f + (progress.toFloat() / seekBar?.max!!) * 190f
                myView1.circleRad = newRadius
                myView1.circleX = myView1.circleRad
                myView1.invalidate()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    fun update(){
        when (colorGroup.checkedRadioButtonId) {
            R.id.red -> myView1.color = Color.RED
            R.id.blue -> myView1.color = Color.BLUE
            R.id.green -> myView1.color = Color.rgb(0,255,0)
        }

        myView1.invalidate()
    }
}
