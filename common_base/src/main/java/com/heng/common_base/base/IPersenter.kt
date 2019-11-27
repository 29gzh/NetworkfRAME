package com.heng.common_base.base

/**
 * @author ziheng
 * @date    2019.11.26
 * @function
 */
interface IPersenter<in V : IView> {

    /**
     * 绑定 View
     */
    fun attachView(mView: V)

    /**
     * 解绑 View
     */
    fun detachView()


}