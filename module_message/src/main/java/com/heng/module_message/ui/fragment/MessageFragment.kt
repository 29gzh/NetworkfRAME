package com.heng.module_message.ui.fragment

import android.view.View
import com.heng.common_base.base.BaseFragment
import com.heng.module_message.R

/**
 * @author guoziheng
 * @description
 * @date 2019/12/1.
 */
class MessageFragment: BaseFragment() {

    companion object{
        fun getInstanse(): MessageFragment = MessageFragment()
    }

    override fun initView(view: View) {

    }

    override fun attachLayoutRes(): Int = R.layout.fragment_message
}