package com.heng.common_base.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
/**
 * @author ziheng
 * @date        2019.11.12
 * @function
 */
abstract class BaseActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        initData()
        onClickListener()
    }

    abstract fun initData()

    abstract fun onClickListener()

    abstract fun getLayout(): Int

}