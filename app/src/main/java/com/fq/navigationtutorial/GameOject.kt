package com.fq.navigationtutorial

import android.graphics.Canvas
import android.graphics.drawable.Drawable

open class GameOject(var x:Int, var y:Int, var dx:Int, var dy:Int, var image: Drawable) {
    var width: Int = 100
    var height: Int = 100

    open fun move(canvas: Canvas)
    {
        x += dx
        y += dy

        if (x > (canvas.width - width) || x < 0)
        {
            dx = -dx
        }
        if (y > (canvas.height - height) || y < 0)
        {
            dy = -dy
        }

        image.setBounds(x, y, x + width, y + height)
        image.draw(canvas)
    }
}