package com.heng.networkframe

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import com.flyco.tablayout.listener.CustomTabEntity
import com.heng.common_base.base.BaseActivity
import com.heng.module_homepage.ui.fragment.HomePageFragment
import com.heng.module_message.ui.fragment.MessageFragment
import com.heng.module_mine.ui.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val BOTTOM_INDEX: String = "bottom_index"

    private val FRAGMENT_HOMEPAGE = 0x01
    private val FRAGMENT_MESSAGE = 0x02
    private val FRAGMENT_MINE = 0x03

    private var mIndex = FRAGMENT_HOMEPAGE

    private var homePageFragment: HomePageFragment? = null
    private var messageFragment: MessageFragment? = null
    private var mineFragment: MineFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        if(savedInstanceState != null){
            mIndex = savedInstanceState?.getInt(BOTTOM_INDEX)
        }
        super.onCreate(savedInstanceState)
    }
    override fun initView() {
        showFragment(mIndex)

        //ArrayList<CustomTabEntity>()

        //tabLayout.setTabData()

    }

    override fun initData() {
    }

    override fun onClickListener() {
    }

    override fun getLayout(): Int = R.layout.activity_main
    override fun useEventBus(): Boolean = true


    private fun showFragment(index: Int){
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        mIndex = index
        when(index){
            FRAGMENT_HOMEPAGE ->{
                if(homePageFragment == null){
                    homePageFragment = HomePageFragment.getInstanse()
                    transaction.add(R.id.frame_view,homePageFragment!!,"homepage")
                }else{
                    transaction.show(homePageFragment!!)
                }
            }
            FRAGMENT_MESSAGE ->{
                if(messageFragment == null){
                    messageFragment = MessageFragment.getInstanse()
                    transaction.add(R.id.frame_view,messageFragment!!,"message")
                }else{
                    transaction.show(messageFragment!!)
                }
            }
            FRAGMENT_MINE ->{
                if(mineFragment == null){
                    mineFragment = MineFragment.getInstanse()
                    transaction.add(R.id.frame_view,mineFragment!!,"mine")
                }else{
                    transaction.show(mineFragment!!)
                }
            }
        }
        transaction.commit()
    }


    /**
     * 隐藏所有的Fragment
     */
    private fun hideFragments(transaction: FragmentTransaction) {
        homePageFragment?.let { transaction.hide(it) }
        messageFragment?.let { transaction.hide(it) }
        mineFragment?.let { transaction.hide(it) }
    }


}
