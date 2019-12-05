package com.heng.module_homepage.ui.fragment

import android.view.View
import com.heng.common_base.base.BaseMvpFragment
import com.heng.common_base.bean.DataBean
import com.heng.common_base.eventbus.EventBusTag
import com.heng.common_base.eventbus.EventMessageBean
import com.heng.module_homepage.R
import com.heng.module_homepage.mvp.contract.HomePageContract
import com.heng.module_homepage.mvp.persenter.HomePagePersenter
import kotlinx.android.synthetic.main.fragment_homepage.*
import org.greenrobot.eventbus.EventBus


/**
 * @author guoziheng
 * @description
 * @date 2019/12/1.
 */
class HomePageFragment: BaseMvpFragment<HomePageContract.View,HomePageContract.Persenter>(),HomePageContract.View{

    companion object{
        fun getInstanse() : HomePageFragment = HomePageFragment()
    }

    override fun createPresenter(): HomePageContract.Persenter = HomePagePersenter()

    override fun attachLayoutRes(): Int = R.layout.fragment_homepage

    override fun useEventBus(): Boolean  = true

    override fun initView(view: View) {
        super.initView(view)

        txt_clearn.setOnClickListener {
            try {
                val eventMessage = EventMessageBean::class.java.newInstance()
                eventMessage.tag = EventBusTag.CLEAR_BRAGE_TAG
                eventMessage.messageInt = 0
                EventBus.getDefault().post(eventMessage)
            }catch (e: Exception){
                e.printStackTrace()
            }

        }


    }




}