package com.test.appe

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

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
        MainActivity.launchActivity(this)
    }
}