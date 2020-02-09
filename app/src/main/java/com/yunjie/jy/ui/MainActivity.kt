package com.yunjie.jy.ui

import android.view.Gravity
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationBar.BACKGROUND_STYLE_RIPPLE
import com.ashokvarma.bottomnavigation.BottomNavigationBar.MODE_FIXED
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.TextBadgeItem
import com.yunjie.jy.R
import com.yunjie.jy.base.BaseActivity
import com.yunjie.jy.ui.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), BottomNavigationBar.OnTabSelectedListener {


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        super.initView()
        bottomNavigationBar?.let {
            it.setMode(MODE_FIXED) // 设置mode
//                .setBackgroundStyle(BACKGROUND_STYLE_RIPPLE)  // 背景样式
                .setBarBackgroundColor("#ffffff") // 背景颜色
                .setInActiveColor("#929292") // 未选中状态颜色
                .setActiveColor("#F95317") // 选中状态颜色F95317
                .addItem(
                    BottomNavigationItem(R.mipmap.ic_home_p, "首页")
                        .setInactiveIconResource(R.mipmap.ic_home_n)
                ) // 添加Item
                .addItem(
                    BottomNavigationItem(R.mipmap.ic_detabase_p, "资料")
                        .setInactiveIconResource(R.mipmap.ic_detabase_n)
                )
                .addItem(
                    BottomNavigationItem(R.mipmap.ic_chengz_p, "成长")
                        .setInactiveIconResource(R.mipmap.ic_chengz_n)
                )
                .addItem(
                    BottomNavigationItem(R.mipmap.ic_our_p, "我的")
                        .setInactiveIconResource(R.mipmap.ic_our_n)
                )
                .setFirstSelectedPosition(0) //设置默认选中位置
                .initialise()  // 提交初始化（完成配置）

            TextBadgeItem()
                .setBackgroundColor("#F95317")
                .setGravity(Gravity.RIGHT or Gravity.TOP) // 默认为右上角
                .setTextColor("#ffffff")
                .setText("3")
                .setHideOnSelect(true)//true：当选中状态时消失，非选中状态显示,moren false
        }
    }

    override fun initEvent() {
        super.initEvent()
        bottomNavigationBar?.let {
            it.setTabSelectedListener(this)
        }
    }

    override fun initData() {
        super.initData()
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, HomeFragment.newInstance("Home")).commit()
    }

    override fun onTabReselected(position: Int) {
    }

    override fun onTabUnselected(position: Int) {
    }

    override fun onTabSelected(position: Int) {
        when (position) {
            1 -> {
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, DatabaseFragment.newInstance("资料"))
                    .commit()
            }
            2 -> {
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, GrowUpFragment.newInstance("成长"))
                    .commit()
            }
            3 -> {
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, OurFragment.newInstance("我的"))
                    .commit()
            }
            else -> {
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, HomeFragment.newInstance("Home"))
                    .commit()
            }
        }
    }
}
