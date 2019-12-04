package com.heng.common_base.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * @author ziheng
 * @date    2019.11.28
 * @function    BaseFragment
 */
abstract class BaseFragment :Fragment(){
    /**
     * 视图是否加载完毕
     */
    private var isViewPrepare = false
    open fun useEventBus(): Boolean = false
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  inflater.inflate(attachLayoutRes(),null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(useEventBus()){
            EventBus.getDefault().register(this)
        }
        isViewPrepare = true
        initView(view)
    }

    abstract fun initView(view: View)

    abstract fun attachLayoutRes(): Int

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getEventMessage(eventMessage: String){

    }

    override fun onDestroy() {
        super.onDestroy()
        if(useEventBus()){
            EventBus.getDefault().unregister(this)
        }
    }

}