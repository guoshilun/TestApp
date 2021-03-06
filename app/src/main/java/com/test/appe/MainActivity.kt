package com.test.appe

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.RadioGroup
import com.test.appe.fragment.HomeFragment
import com.test.appe.fragment.MineFragment
import com.test.appe.fragment.TypeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //    var REGEX_PWD = "^(?![0-9]+$)(?![a-z]+$)(?![A-Z]+$)([a-z]|[A-Z]|[0-9]){8,16}$"//大小写字母及数字三选二组合
//    var REGEX_PWD = "^(?=.*\\d)(?=.*[a-z])[a-zA-Z0-9]{8,16}$"// 大小写字母都必须包含
    private lateinit var fm: FragmentManager
    private var hf: HomeFragment? = null
    private var tf: TypeFragment? = null
    private var mf: MineFragment? = null
    private var mATMessages = mutableListOf<String>()
    private var list = mutableListOf<String>()

    companion object {
        fun launchActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_voice_room_layout)
        mATMessages.add("1111")
        mATMessages.add("1234")
        mATMessages.add("1222")
        mATMessages.add("1333")
        mATMessages.add("1444")
        list.addAll(mATMessages.filter { it != "1444" }.take(1).toList())
//        Log.e("tag", list.toString())
        mATMessages.forEach {
            if (it=="1234"){
                Log.e("tag","1234")
                return@forEach
            }
            Log.e("tag","end")
        }
//        switchFragment(R.id.rb_home)
//        rg_tab.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId -> switchFragment(checkedId) })


//        list.add("qwerW854321")
//        list.add("qwer854321")
//        list.add("WWW854321")
//        list.add("1234qwerW854321")
//        list.add("1234qwerW8543211111111")
//        list.add("aaaaQWEeR")
//        list.add("1234")
//        list.add("123456783")
//        list.add("1234....")
//        list.add("QQQQQQQQ")
//        list.add("qqqqqqqq")
//        list.add("!@#\$qqqq")
//        list.add("!@#\$1234Wq")
//        list.add("@#\$!@#\$")
//        findViewById(R.id.start).setOnClickListener {
//            list.indices.forEach {
//                Log.e("", "")
//                Log.e("tag-->", list[it] + "   ${list[it].matches(Regex(REGEX_PWD))}")
//            }isInitialized
//        }
    }
//
//    private fun switchFragment(v: Int) {
//        if (!::fm.isInitialized) {
//            fm = supportFragmentManager
//        }
//        val ft: FragmentTransaction = fm.beginTransaction()
//        hideFragments(ft)
//        when (v) {
//            R.id.rb_home -> if (hf == null) {
//                hf = HomeFragment.newInstance()
//                ft.add(R.id.home_fragment, hf)
//                tv_title.text="米趣家"
//            } else {
//                tv_title.text="米趣家"
//                ft.show(hf)
//            }
//            R.id.rb_type -> if (tf == null) {
//                tf = TypeFragment()
//                ft.add(R.id.home_fragment, tf)
//                tv_title.text="内容"
//            } else {
//                tv_title.text="内容"
//                ft.show(tf)
//            }
//            R.id.rb_mine -> if (mf == null) {
//                mf = MineFragment.newInstance()
//                ft.add(R.id.home_fragment, mf)
//                tv_title.text="我的"
//            } else {
//                tv_title.text="我的"
//                ft.show(mf)
//            }
//            else -> if (hf == null) {
//                hf = HomeFragment.newInstance()
//                ft.add(R.id.home_fragment, hf)
//                tv_title.text="米趣家"
//            } else {
//                tv_title.text="米趣家"
//                ft.show(hf)
//            }
//        }
//        ft.commitAllowingStateLoss()
//    }
//
//    private fun hideFragments(ft: FragmentTransaction?) {
//        if (ft == null) {
//            return
//        }
//        if (hf != null) {
//            ft.hide(hf)
//        }
//        if (tf != null) {
//            ft.hide(tf)
//        }
//        if (mf != null) {
//            ft.hide(mf)
//        }
//    }
}