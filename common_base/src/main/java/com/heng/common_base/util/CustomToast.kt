package com.heng.common_base.util

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.heng.common_base.R

/**
 * @author ziheng
 * @date        2019.11.27
 * @function        自定义Toast
 */
class CustomToast {

    private var toast: Toast
    private var textView: TextView

    constructor(context: Context?, message: String) : this(context, message, Toast.LENGTH_SHORT)

    constructor(context: Context?, message: String, duration: Int) {
        toast = Toast(context)
        toast.duration = duration
        val view = View.inflate(context, R.layout.toast_custom, null)
        textView = view.findViewById(R.id.tv_prompt)
        textView.text = message
        toast.view = view
        toast.setGravity(Gravity.CENTER, 0, 0)
    }

    fun show() {
        toast.show()
    }

}