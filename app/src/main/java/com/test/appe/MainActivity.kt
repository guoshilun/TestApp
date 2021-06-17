package com.test.appe

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {
    var REGEX_PWD = "^(?![0-9]+$)(?![a-z]+$)(?![A-Z]+$)([a-z]|[A-Z]|[0-9]){8,16}$"
    var password = "12345678"
    var password1 = "1234qwer87654321"
    var password2 = "1234QWER"
    var password3 = "1234...."
    var password4 = "QQQQQQQQ"
    var password5 = "qqqqqqqq"
    var password6 = "!@#$\$qqqq"
    var password7 = "!@#$$1234"
    var password8 = "!@#$$!@#$$"

    val list = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.add(password)
        list.add(password1)
        list.add(password2)
        (list.indices).forEach {

            Log.e("tag", list[it])
        }

        Log.e("tag1---->", password.matches(Regex(REGEX_PWD)).toString() + "")
        Log.e("tag2---->", password1.matches(Regex(REGEX_PWD)).toString() + "")
        Log.e("tag3---->", password2.matches(Regex(REGEX_PWD)).toString() + "")
        Log.e("tag4---->", password3.matches(Regex(REGEX_PWD)).toString() + "")
        Log.e("tag5---->", password4.matches(Regex(REGEX_PWD)).toString() + "")
        Log.e("tag6---->", password5.matches(Regex(REGEX_PWD)).toString() + "")
        Log.e("tag7---->", password6.matches(Regex(REGEX_PWD)).toString() + "")
        Log.e("tag8---->", password7.matches(Regex(REGEX_PWD)).toString() + "")
        Log.e("tag9---->", password8.matches(Regex(REGEX_PWD)).toString() + "")
    }
}