package com.fq.navigationtutorial

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class DrawingView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var paint = Paint()
    var drawX: Float = 100f
    var drawY: Float = 100f
    lateinit var bitmap: Bitmap
    lateinit var bitmapCanvas: Canvas
    var drawWidth: Int = 800
    var drawHeight: Int = 800

    init {
        paint.color = Color.RED
        paint.textSize = 80f
    }

    override fun onDrawForeground(canvas: Canvas?) {
        super.onDrawForeground(canvas)
        //canvas!!.drawText("Some text", drawX, drawY, paint)
        bitmapCanvas.drawCircle(drawX, drawY, 10f, paint)
        canvas!!.drawBitmap(bitmap, 0f, 0f, null)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        //return super.onTouchEvent(event)
        if (event!!.action == MotionEvent.ACTION_MOVE)
        {
            drawX = event!!.x
            drawY = event!!.y
            invalidate()
        }
        return true
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        drawWidth = measuredWidth
        drawHeight = measuredHeight
        bitmap = Bitmap.createBitmap(drawWidth, drawHeight, Bitmap.Config.RGB_565)
        bitmapCanvas = Canvas(bitmap)
    }
}