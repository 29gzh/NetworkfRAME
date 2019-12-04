package com.heng.common_base.base

import android.view.View
import com.heng.common_base.ext.showToast

/**
 * @author guoziheng
 * @description
 * @date 2019/12/1.
 */
abstract class BaseMvpFragment<in V: IView,P: IPersenter<V>>: BaseFragment(),IView{


    protected var mPersenter: P? = null

    abstract fun createPresenter(): P

    override fun initView(view: View) {
        mPersenter = createPresenter()
        mPersenter?.attachView(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPersenter?.detachView()
        this.mPersenter = null
    }


    override fun showLoading() {

    }

    override fun hideLoading() {
    }

    override fun showDefaultMsg(msg: String) {
        //showToast(msg)
    }

    override fun showMsg(msg: String) {
        //showToast(msg)
    }

    override fun showError(errorMsg: String) {
        //showToast(errorMsg)
    }
}