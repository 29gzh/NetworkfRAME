package com.heng.common_base.base

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDexApplication
import kotlin.properties.Delegates

/**
 * @author ziheng
 * @date   2019/12/9.
 * @function
 */
class BaseApplication : MultiDexApplication(){

    companion object{

        var context: Context by Delegates.notNull()
            private set     //只允许本类修改

        lateinit var instanse :Application
    }

    override fun onCreate() {
        super.onCreate()
        instanse = this
        context = applicationContext

    }


}