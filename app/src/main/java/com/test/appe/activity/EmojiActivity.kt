package com.test.appe.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.test.appe.R
import com.test.appe.utils.L

class EmojiActivity : AppCompatActivity() {
    companion object {
        fun launchActivity(context: Context) {
            val intent = Intent(context, EmojiActivity::class.java)
            context.startActivity(intent)
        }
    }

    private val REGEX_PWD_NEW = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{8,16}$"
    private val password = "aaaaaaaaaaaA2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emoji)
        L.e(password.matches(Regex(REGEX_PWD_NEW)))
    }
}