package com.fq.navigationtutorial

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

class SensorView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var paint = Paint()
    var sensorX:Float = 0f
    var sensorY:Float = 100f
    var sensorText: String = "Sensor view text"

//    private val myListener =  object : GestureDetector.SimpleOnGestureListener() {
//        override fun onDown(e: MotionEvent): Boolean {
//            return true
//        }
//    }
//    private val detector: GestureDetector = GestureDetector(context, myListener)

    init{
        paint.color = Color.RED
        paint.textSize = 80f
    }

    override fun onDrawForeground(canvas: Canvas?) {
        super.onDrawForeground(canvas)
        canvas!!.drawText(sensorText, sensorX, sensorY, paint)
    }

//    override fun onTouchEvent(event: MotionEvent): Boolean {
//        Log.d("touch", event.toString())
//        return detector.onTouchEvent(event).let { result ->
//            if (!result) {
//                if (event.action == MotionEvent.ACTION_MOVE) {
//                    Log.d("move", event.action.toString())
//                    true
//                } else false
//            } else true
//        }
//    }
}