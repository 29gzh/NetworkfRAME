package com.heng.common_base.base

import io.reactivex.disposables.Disposable

/**
 * @author ziheng
 * @date    2019.11.26
 * @function
 */
interface IModel {

    fun addDisposable(disposable: Disposable)

    fun onDetach()

}