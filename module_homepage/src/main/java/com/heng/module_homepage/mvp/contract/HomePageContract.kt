package com.heng.module_homepage.mvp.contract

import com.heng.common_base.base.IModel
import com.heng.common_base.base.IPersenter
import com.heng.common_base.base.IView

/**
 * @author guoziheng
 * @description
 * @date 2019/12/1.
 */
interface HomePageContract {

    interface View: IView{

    }

    interface Persenter: IPersenter<View>{}


    interface Model: IModel{}



}