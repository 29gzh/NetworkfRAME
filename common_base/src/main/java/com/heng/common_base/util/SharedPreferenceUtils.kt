package com.heng.common_base.util

import android.content.Context
import android.content.SharedPreferences
import com.heng.common_base.base.BaseApplication
import java.io.*
import kotlin.reflect.KProperty

/**
 * @author ziheng
 * @date   2019/12/9.
 * @function    kotlin委托属性+SharedPreference实例
 */
class SharedPreferenceUtils<T>(val name: String,private val default: T) {

    companion object{
        private val file_name = "wan_android_file"

        private val sp: SharedPreferences by lazy {
            BaseApplication.context.getSharedPreferences(file_name, Context.MODE_PRIVATE)
        }

        /**
         *删除全部信息
         */
        fun clearSp(){
            sp.edit().clear().apply()
        }

        /**
         * 根据key清除值
         */
        fun clearKeySp(key: String){
            sp.edit().remove(key).apply()
        }

        /**
         * 判断储存中是否存在某个key值
         */
        fun containsKey(key: String): Boolean{
            return sp.contains(key)
        }

        /**
         * 查询所有信息
         */
        fun getAll(): Map<String,*>{
            return sp.all
        }

    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return getSharedPreferences(name, default)
    }

    operator fun setValue(thisRef :Any?, property: KProperty<*>, value: T){
        putSharedPreferences(name,value)
    }

    private fun putSharedPreferences(name: String,value: T) = with(sp.edit()){
        when(value){
            is Long -> putLong(name, value)
            is String -> putString(name, value)
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            else -> putString(name, serialize(value))
        }
    }

    private fun getSharedPreferences(name: String, default: T): T = with(sp) {
        val res: Any = when (default) {
            is Long -> getLong(name, default)
            is String -> getString(name, default)
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)
            else -> deSerialization(getString(name, serialize(default)))
        }
        return res as T
    }

    /**
     * 序列化对象

     * @param person
     * *
     * @return
     * *
     * @throws IOException
     */
    @Throws(IOException::class)
    private fun <A> serialize(obj: A): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val objectOutputStream = ObjectOutputStream(
            byteArrayOutputStream)
        objectOutputStream.writeObject(obj)
        var serStr = byteArrayOutputStream.toString("ISO-8859-1")
        serStr = java.net.URLEncoder.encode(serStr, "UTF-8")
        objectOutputStream.close()
        byteArrayOutputStream.close()
        return serStr
    }

    /**
     * 反序列化对象

     * @param str
     * *
     * @return
     * *
     * @throws IOException
     * *
     * @throws ClassNotFoundException
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IOException::class, ClassNotFoundException::class)
    private fun <A> deSerialization(str: String): A {
        val redStr = java.net.URLDecoder.decode(str, "UTF-8")
        val byteArrayInputStream = ByteArrayInputStream(
            redStr.toByteArray(charset("ISO-8859-1")))
        val objectInputStream = ObjectInputStream(
            byteArrayInputStream)
        val obj = objectInputStream.readObject() as A
        objectInputStream.close()
        byteArrayInputStream.close()
        return obj
    }


}