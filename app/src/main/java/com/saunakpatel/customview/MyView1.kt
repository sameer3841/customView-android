package com.saunakpatel.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.View

class MyView1(context: Context?, attrs: AttributeSet?): View(context, attrs) {
    var drawCircle: Boolean = false
    private var paint: Paint

    var circleRad: Float = 10f
    var circleX: Float = circleRad
    private var color: Int = Color.RED;




    init {
        paint = Paint()

    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas){
        paint.setColor(color)
        val paintRect = Paint()
        paintRect.setColor(Color.BLUE)
        if (drawCircle) canvas.drawCircle(circleX, 200f, circleRad, paint)
        else canvas.drawColor(Color.TRANSPARENT)

        canvas.drawRect(10f, 600f, 1070f, 800f, paintRect)

    }
}