package com.heng.module_homepage.custom

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.ImageView
import com.heng.module_homepage.R

/**
 * @author ziheng
 * @date   2019/12/6.
 * @function
 */
class CustomImageLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {

    private var mPaint: Paint = Paint()
    private var mHeight: Int = 0
    private var mWidth: Int = 0
    private var mRadius: Int = 0
    private var mCx: Int = 0
    private var mCy: Int = 0
    private var mRectF: RectF = RectF()

    private var mBitmap: Bitmap
    private lateinit var  mLinearGradient: LinearGradient
    init {
        mPaint.color = Color.BLUE
        mPaint.strokeWidth = 10f
        mPaint.style = Paint.Style.FILL
        mPaint.isAntiAlias = true
        mBitmap = BitmapFactory.decodeResource(context?.resources, R.drawable.zh_img)

    }

    @SuppressLint("ResourceAsColor")
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mHeight = h
        mWidth = w
        mRadius = mWidth

        mCx = w / 2
        mCy = h - w * 2

        mRectF.top=0f
        mRectF.left=0f
        mRectF.bottom=mHeight.toFloat()
        mRectF.right=mWidth.toFloat()
        mLinearGradient = LinearGradient(mWidth / 2f, 0f, mWidth / 2f, mHeight.toFloat(), R.color._xpopup_content_color, R.color.white, Shader.TileMode.MIRROR)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val layerId= canvas!!.saveLayer(mRectF,mPaint)
        canvas.drawCircle(mCx.toFloat(),mCy.toFloat(),mRadius.toFloat(),mPaint)
        mPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(mBitmap,null,mRectF,mPaint)
        mPaint.xfermode=null
        canvas.restoreToCount(layerId)


    }


}