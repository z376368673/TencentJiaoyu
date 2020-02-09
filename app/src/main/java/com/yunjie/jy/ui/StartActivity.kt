package com.yunjie.jy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import com.library.common.https.HttpClient
import com.library.common.https.ResultBean
import com.library.common.https.ResultDataCallback
import com.yunjie.jy.R
import com.yunjie.jy.api.API
import com.yunjie.jy.base.BaseActivity

/**
 * 启动界面
 */
class StartActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_start
    }

    override fun initView() {
        super.initView()
    }

    override fun initData() {
        super.initData()
        Handler().postDelayed(Runnable {
            startAct(MainActivity::class.java)
        },3000)
    }

    /**
     * 获取验证码
     */
    private fun getYzmCode(phone: String) {
        if (TextUtils.isEmpty(phone) || phone.length != 11) {
            return
        }
        val call = HttpClient.getApi(API::class.java).sendSms(phone)
        HttpClient.enqueue(call, object : ResultDataCallback(this, true) {
            override fun onResult(bean: ResultBean?, msg: String?) {
            }
        })
    }
}
