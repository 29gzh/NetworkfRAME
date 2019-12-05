package com.heng.common_base.util

import android.os.Environment
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.util.*


/**
 * @author ziheng
 * @date   2019/12/5.
 * @function
 */
class BuildProperties {
    private lateinit var properties: Properties

    @Throws(IOException::class)
    private fun BuildProperties(){
        properties = Properties()
        properties.load(FileInputStream(File(Environment.getRootDirectory(), "build.prop")))
    }

    fun containsKey(key: Any): Boolean {
        return properties.containsKey(key)
    }

    fun containsValue(value: Any): Boolean {
        return properties.containsValue(value)
    }

    fun entrySet(): MutableSet<MutableMap.MutableEntry<Any, Any>> {
        return properties.entries
    }

    fun getProperty(name: String): String {
        return properties.getProperty(name)
    }

    fun getProperty(name: String, defaultValue: String?): String {
        return properties.getProperty(name, defaultValue)
    }

    fun isEmpty(): Boolean {
        return properties.isEmpty
    }

    fun keys(): Enumeration<Any> {
        return properties.keys()
    }

    fun keySet(): Set<Any> {
        return properties.keys
    }

    fun size(): Int {
        return properties.size
    }

    fun values(): Collection<Any> {
        return properties.values
    }


    companion object{
        @Throws(IOException::class)
        fun newInstance(): BuildProperties{
            return BuildProperties()
        }
    }


}