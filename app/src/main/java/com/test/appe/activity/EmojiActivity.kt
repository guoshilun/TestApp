package com.test.appe.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.test.appe.R

class EmojiActivity : AppCompatActivity() {
    companion object {
        fun launchActivity(context: Context) {
            val intent = Intent(context, EmojiActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_emoji)
    }
}