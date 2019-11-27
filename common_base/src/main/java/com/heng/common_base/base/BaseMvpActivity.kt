package com.heng.common_base.base

import com.heng.common_base.ext.showToast

/**
 * @author ziheng
 * @date        2019.11.26
 * @function    BaseMvpActivity
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseMvpActivity <in V: IView, P: IPersenter<V>>: BaseActivity(),IView{


    protected var mPresenter: P? = null

    protected abstract fun createPresenter():P
    override fun initView() {
        mPresenter = createPresenter()
        mPresenter?.attachView(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detachView()
        this.mPresenter = null
    }

    override fun showLoading() {

    }

    override fun hideLoading() {
    }

    override fun showDefaultMsg(msg: String) {
        showToast(msg)
    }

    override fun showMsg(msg: String) {
        showToast(msg)
    }

    override fun showError(errorMsg: String) {
        showToast(errorMsg)
    }

}