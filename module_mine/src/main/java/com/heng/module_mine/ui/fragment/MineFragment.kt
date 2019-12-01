package com.heng.module_mine.ui.fragment

import android.view.View
import com.heng.common_base.base.BaseFragment
import com.heng.module_mine.R

/**
 * @author guoziheng
 * @description
 * @date 2019/12/1.
 */
class MineFragment: BaseFragment() {

    companion object{
        fun getInstanse():MineFragment = MineFragment()
    }


    override fun initView(view: View) {

    }

    override fun attachLayoutRes(): Int = R.layout.fragment_mine
}