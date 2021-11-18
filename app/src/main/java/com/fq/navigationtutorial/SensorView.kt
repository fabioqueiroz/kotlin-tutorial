package com.fq.navigationtutorial

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class SensorView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var paint= Paint()
    var sensorX:Float = 100f
    var sensorY:Float = 100f
    var sensorText: String = "Sensor view text"

    init{
        paint.color = Color.RED
        paint.textSize = 80f
    }

    override fun onDrawForeground(canvas: Canvas?) {
        super.onDrawForeground(canvas)
        canvas!!.drawText(sensorText, sensorX, sensorY, paint)
    }
}