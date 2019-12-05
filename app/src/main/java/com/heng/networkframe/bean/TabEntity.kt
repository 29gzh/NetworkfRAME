package com.heng.networkframe.bean

import com.flyco.tablayout.listener.CustomTabEntity

/**
 * @author ziheng
 * @date   2019/12/5.
 * @function
 */
class TabEntity : CustomTabEntity {

    private val title: String

    private val icon: Int

    private val selectIcon: Int

    constructor(title: String, icon: Int, selectIcon: Int) {
        this.title = title
        this.icon = icon
        this.selectIcon = selectIcon
    }

    override fun getTabUnselectedIcon(): Int {
        return icon
    }

    override fun getTabSelectedIcon(): Int {
        return selectIcon
    }

    override fun getTabTitle(): String {
        return title
    }
}