package com.heng.module_homepage.mvp.persenter

import com.heng.common_base.base.BasePersenter
import com.heng.module_homepage.mvp.contract.HomePageContract
import com.heng.module_homepage.mvp.model.HomePageModel

/**
 * @author guoziheng
 * @description
 * @date 2019/12/1.
 */
class HomePagePersenter: BasePersenter<HomePageContract.Model,HomePageContract.View>(),HomePageContract.Persenter{

    override fun createModel(): HomePageContract.Model? = HomePageModel()
}