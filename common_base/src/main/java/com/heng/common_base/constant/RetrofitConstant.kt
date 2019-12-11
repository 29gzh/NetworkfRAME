package com.heng.common_base.constant

import com.heng.common_base.util.SharedPreferenceUtils

/**
 * @author ziheng
 * @date   2019/12/9.
 * @function
 */
object RetrofitConstant {

    const val BASE_URL = "https://www.wanandroid.com/"      //域名
    const val DEFAULT_TIMEOUT: Long = 15            //请求超时时间
    const val SAVE_USER_LOGIN_KEY = "user/login"        //登录
    const val SAVE_USER_REGISTER_KEY = "user/register"          //注册
    const val SET_COOKIE_KEY = "set-cookie"         //head中的cookie
    const val COOKIE = "cookie"

    fun encodeCookie(cookies: List<String>): String {
        val sb = StringBuilder()
        val set = HashSet<String>()
        cookies
            .map { cookie ->
                cookie.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            }
            .forEach {
                it.filterNot { set.contains(it) }.forEach { set.add(it) }
            }
        val ite = set.iterator()
        while (ite.hasNext()) {
            val cookie = ite.next()
            sb.append(cookie).append(";")
        }
        val last = sb.lastIndexOf(";")
        if (sb.length - 1 == last) {
            sb.deleteCharAt(last)
        }

        return sb.toString()
    }

    fun saveCookie(cookie: String?,domain: String?){
        cookie?: return
        var p: String by SharedPreferenceUtils(COOKIE,cookie)
        @Suppress("UNUSED_VALUE")
        p = cookie
        domain?: return
        var o : String by SharedPreferenceUtils(domain,cookie)
        @Suppress("UNUSED_VALUE")
        o = cookie

    }
}