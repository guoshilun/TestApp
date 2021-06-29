package com.test.appe.activity

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.test.appe.R

class SplashActivity : AppCompatActivity() {
    private var mainHandler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mainHandler.postDelayed({
            ///进入应用
            enterApp()
        }, 2000)
    }

    private fun enterApp() {
        EmojiActivity.launchActivity(this)
    }
}