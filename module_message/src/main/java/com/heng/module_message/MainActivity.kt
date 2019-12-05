package com.heng.module_message

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.heng.module_message.ui.fragment.MessageFragment

/**
 * @author ziheng
 * @date
 * @function
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.message_frame,MessageFragment())

    }

}