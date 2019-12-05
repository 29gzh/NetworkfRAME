package com.heng.common_base.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.heng.common_base.eventbus.EventMessageBean
import com.heng.common_base.util.TitleBarUtils
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * @author ziheng
 * @date        2019.11.12
 * @function
 */
abstract class BaseActivity :AppCompatActivity(){

    /**
     * 是否使用 EventBus
     */
    open fun useEventBus(): Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        //Utils.setStatusTextColor(false, MainActivity.this);		状态栏字体是白色的
        TitleBarUtils.setStatusBar(this,
            useThemestatusBarColor = false,
            withoutUseStatusBarColor = false
        )//状态栏字体是黑色的
        if(useEventBus()){
            EventBus.getDefault().register(this)
        }
        initView()
        initData()
        onClickListener()
    }

    abstract fun initView()

    abstract fun initData()

    abstract fun onClickListener()

    protected abstract fun getLayout(): Int

    override fun onBackPressed() {
        super.onBackPressed()
        // Fragment 逐个出栈
        val count = supportFragmentManager.backStackEntryCount
        if (count == 0) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun getEventMessage(eventMessage: EventMessageBean){

    }


    override fun onDestroy() {
        super.onDestroy()
        if(useEventBus()){
            EventBus.getDefault().unregister(this)
        }
    }

}