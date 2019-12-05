package com.heng.module_homepage

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.heng.module_homepage.ui.fragment.HomePageFragment

/**
 * @author ziheng
 * @date    2019.12.4
 * @function
 */
class MainActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.main_frame,HomePageFragment())

    }
}