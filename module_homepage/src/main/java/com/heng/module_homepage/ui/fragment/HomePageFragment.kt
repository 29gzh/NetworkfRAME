package com.heng.module_homepage.ui.fragment

import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.view.View
import android.widget.ImageView
import com.heng.common_base.base.BaseMvpFragment
import com.heng.common_base.bean.DataBean
import com.heng.common_base.eventbus.EventBusTag
import com.heng.common_base.eventbus.EventMessageBean
import com.heng.module_homepage.R
import com.heng.module_homepage.custom.CustomTitleTabLayout
import com.heng.module_homepage.mvp.contract.HomePageContract
import com.heng.module_homepage.mvp.persenter.HomePagePersenter
import com.heng.module_homepage.ui.activity.ImageViewActivity
import kotlinx.android.synthetic.main.fragment_homepage.*
import kotlinx.android.synthetic.main.fragment_homepage.view.*
import org.greenrobot.eventbus.EventBus
import org.jetbrains.anko.image


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

        circular_image.setOnClickListener {
            Intent(activity,ImageViewActivity::class.java).run {
                startActivity(this,
                    ActivityOptionsCompat.makeSceneTransitionAnimation(activity!!, circular_image, "image").toBundle())
            }
        }


    }




}