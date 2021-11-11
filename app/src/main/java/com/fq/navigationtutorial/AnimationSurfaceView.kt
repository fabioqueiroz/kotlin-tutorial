package com.fq.navigationtutorial

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.util.ArrayList

class AnimationSurfaceView(context: Context?, attrs: AttributeSet?) : SurfaceView(context, attrs), Runnable {
    var paint = Paint()
    var isRunning = true
    lateinit var animationThread: Thread
    lateinit var surfaceHolder: SurfaceHolder
    var gameOjects = ArrayList<GameOject>()

    init {
        paint.color = Color.WHITE
        val ball1 = context!!.resources.getDrawable(R.drawable.ball1, null)
        gameOjects.add(GameOject(100, 100, 10, 10, ball1))
        animationThread = Thread(this)
        animationThread.start()
        surfaceHolder = holder
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
                gameObject.move(canvas)
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

}