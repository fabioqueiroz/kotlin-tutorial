package com.fq.navigationtutorial

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.opengl.GLSurfaceView
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.util.ArrayList

class AnimationSurfaceView(context: Context?, attrs: AttributeSet?) : SurfaceView(context, attrs), Runnable {
    var paint = Paint()
    var isRunning = true
    lateinit var animationThread: Thread
    lateinit var surfaceHolder: SurfaceHolder
    var gameOjects = ArrayList<GameOject>()
    //lateinit var ball1: Drawable

//    private val myListener =  object : GestureDetector.SimpleOnGestureListener() {
//        override fun onDown(e: MotionEvent): Boolean {
//            return true
//        }
//    }
//    private val detector: GestureDetector = GestureDetector(context, myListener)

    init {
        paint.color = Color.WHITE
        val ball1 = context!!.resources.getDrawable(R.drawable.ball1, null)
        val square = context!!.resources.getDrawable(R.drawable.square, null)
        gameOjects.add(GameOject(300, 100, 10, 10, ball1))
        gameOjects.add(GameOject(100, 100, 20, 0, square))
        animationThread = Thread(this)
        animationThread.start()
        surfaceHolder = holder
        //R.drawable.
    }

    override fun run() {
        while (isRunning)
        {
            if (!surfaceHolder.surface.isValid)
            {
                continue
            }

            val canvas: Canvas = surfaceHolder.lockCanvas()
            canvas.drawRect(0f, 0f, canvas.width.toFloat(), canvas.height.toFloat(), paint)
            for (gameObject in gameOjects)
            {
                //gameObject.move(canvas)
                gameObject.moveVertically(canvas)
            }
            surfaceHolder.unlockCanvasAndPost(canvas)

        }
    }

    fun stop() {
        isRunning = false
        while (true) {
            try {
                animationThread.join()
                break
            } catch (e: InterruptedException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            } // block until thread dies
            break
        }
    }

    fun start() {
        isRunning = true
        animationThread = Thread(this)
        animationThread.start()
    }

//    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        Log.d("touch", event.toString())
//
//        return super.onTouchEvent(event)
//    }

//    override fun onTouchEvent(event: MotionEvent): Boolean {
//        Log.d("touch", event.toString())
//        return detector.onTouchEvent(event).let { result ->
//            if (!result) {
//                if (event.action == MotionEvent.ACTION_DOWN) {
//                    Log.d("event.action ", event.action.toString())
//                    true
//                } else false
//            } else true
//        }
//    }
}