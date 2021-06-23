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
        setContentView(R.layout.activity_main)
        switchFragment(R.id.rb_home)
        rg_tab.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId -> switchFragment(checkedId) })
    }

    private fun switchFragment(v: Int) {
        if (!::fm.isInitialized) {
            fm = supportFragmentManager
        }
        val ft: FragmentTransaction = fm.beginTransaction()
        hideFragments(ft)
        when (v) {
            R.id.rb_home -> if (hf == null) {
                hf = HomeFragment.newInstance()
                ft.add(R.id.home_fragment, hf)
                tv_title.text = "米趣家"
            } else {
                tv_title.text = "米趣家"
                ft.show(hf)
            }
            R.id.rb_type -> if (tf == null) {
                tf = TypeFragment()
                ft.add(R.id.home_fragment, tf)
                tv_title.text = "DIY"
            } else {
                tv_title.text = "DIY"
                ft.show(tf)
            }
            R.id.rb_mine -> if (mf == null) {
                mf = MineFragment.newInstance()
                ft.add(R.id.home_fragment, mf)
                tv_title.text = "我的"
            } else {
                tv_title.text = "我的"
                ft.show(mf)
            }
            else -> if (hf == null) {
                hf = HomeFragment.newInstance()
                ft.add(R.id.home_fragment, hf)
                tv_title.text = "米趣家"
            } else {
                tv_title.text = "米趣家"
                ft.show(hf)
            }
        }
        ft.commitAllowingStateLoss()
    }

    private fun hideFragments(ft: FragmentTransaction?) {
        if (ft == null) {
            return
        }
        if (hf != null) {
            ft.hide(hf)
        }
        if (tf != null) {
            ft.hide(tf)
        }
        if (mf != null) {
            ft.hide(mf)
        }
    }
}