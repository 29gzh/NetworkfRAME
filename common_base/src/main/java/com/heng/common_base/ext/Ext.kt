package com.heng.common_base.ext

import android.content.Context
import com.heng.common_base.util.CustomToast

/**
 * @author ziheng
 * @date        2019.11.27
 * @function
 */

fun Context.showToast(content: String) {
    CustomToast(this, content).show()
}
