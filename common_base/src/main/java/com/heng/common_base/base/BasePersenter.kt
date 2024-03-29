package com.heng.common_base.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.greenrobot.eventbus.EventBus

/**
 * @author guoziheng
 * @description
 * @date 2019/12/1.
 */
abstract class BasePersenter<M: IModel,V: IView>: IPersenter<V>, LifecycleObserver{

    protected var mModel: M? = null
    protected var mView: V? = null

    private val isViewAttached: Boolean
        get() = mView != null
    private var mCompositeDisposable: CompositeDisposable? = null

    open fun createModel(): M? = null
    /**
     * 是否使用 EventBus
     */
    open fun useEventBus(): Boolean = false

    override fun attachView(mView: V) {
        this.mView = mView
        mModel = createModel()
        if(mView is LifecycleOwner){
            (mView as LifecycleOwner).lifecycle.addObserver(this)
            if(mModel != null && mModel is LifecycleObserver){
                (mView as LifecycleOwner).lifecycle.addObserver(mModel as LifecycleObserver)
            }
        }
        if(useEventBus()){
            EventBus.getDefault().register(this)
        }
    }

    override fun detachView() {
        if(useEventBus()){
            EventBus.getDefault().unregister(this)
        }
        unDispose()
        mModel?.onDetach()
        this.mModel = null
        this.mView = null
        this.mCompositeDisposable = null
    }

    open fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }

    @Deprecated("")
    open fun addSubscription(disposable: Disposable?) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = CompositeDisposable()
        }
        disposable?.let { mCompositeDisposable?.add(it) }
    }

    open fun addDisposable(disposable: Disposable?) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = CompositeDisposable()
        }
        disposable?.let { mCompositeDisposable?.add(it) }
    }

    private fun unDispose() {
        mCompositeDisposable?.clear()  // 保证Activity结束时取消
        mCompositeDisposable = null
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(owner: LifecycleOwner) {
        // detachView()
        owner.lifecycle.removeObserver(this)
    }

    private class MvpViewNotAttachedException internal constructor() : RuntimeException("Please call IPresenter.attachView(IBaseView) before" + " requesting data to the IPresenter")

}