package com.ducnm.bruhmovie.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class SquareView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    // Paint object for coloring and styling
    private val normalPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val pressedPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    // Some colors for the face background, eyes and mouth.
    private var faceColor = Color.YELLOW
    private var eyesColor = Color.BLACK
    private var mouthColor = Color.BLACK
    private var borderColor = Color.BLACK

    // Face border width in pixels
    private var borderWidth = 4.0f

    // View size in pixels
    private var size = 320
    override fun onAttachedToWindow() {

        super.onAttachedToWindow()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        size = Math.min(measuredWidth, measuredHeight)

        setMeasuredDimension(size, size)
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

//        normalPaint.color = Color.YELLOW
//        normalPaint.style = Paint.Style.FILL_AND_STROKE
//        normalPaint.strokeWidth = 10f
//        canvas.drawRect(size/1f, size/1f, size/3f, size/3f, normalPaint)
//        //canvas.draw
//
//        // Draw something
//        pressedPaint.color = eyesColor
//        pressedPaint.style = Paint.Style.FILL_AND_STROKE
//        pressedPaint.strokeWidth = 10f
//
//        if(isPressed){
//            canvas.drawRect(size/1f, size/1f, size/3f, size/3f, pressedPaint)
//            canvas.drawCircle(size/2f, size/2f, size/2f, normalPaint)
//        }
//
//        // Rectangle
//
//
//        //canvas.drawCircle(size/2f, size/2f, size/2f, paint)
//
//        normalPaint.color = borderColor
//        normalPaint.style = Paint.Style.STROKE
//        normalPaint.strokeWidth = borderWidth
//
//        canvas.drawCircle(size/2f, size/2f, size/2 - borderWidth/2, normalPaint)

        normalPaint.color = Color.RED
        normalPaint.style = Paint.Style.FILL_AND_STROKE
        normalPaint.strokeWidth = 10f


        canvas.drawLine(size / 2f, 0f, 0f, size / 1f, normalPaint)
        canvas.drawLine(size / 2f, 0f, size / 1f, size / 1f, normalPaint)
        canvas.drawLine(0f, size / 1f, size / 1f, size / 3f, normalPaint)
        canvas.drawLine(0f, size / 3f, size / 1f, size / 3f, normalPaint)
        canvas.drawLine(0f, size / 3f, size / 1f, size / 1f, normalPaint)
    }

    override fun drawableStateChanged() {
        super.drawableStateChanged()
        invalidate()
    }
}