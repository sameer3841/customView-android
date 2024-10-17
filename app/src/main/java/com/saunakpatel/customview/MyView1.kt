package com.saunakpatel.customview

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
    init {
        paint = Paint()
    }

    override fun onDraw(canvas: Canvas){
        paint.setColor(Color.RED)
        if (drawCircle) canvas.drawCircle(200f, 200f, 80f, paint)
        else canvas.drawColor(Color.TRANSPARENT)
    }
}