package com.yunjie.jy.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.view.View
import com.library.common.https.HttpClient
import com.library.common.https.ResultBean
import com.library.common.https.ResultDataCallback
import com.orz.nb.plus.redpacket.utils.singleClick
import com.yunjie.jy.R
import com.yunjie.jy.api.API
import com.yunjie.jy.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

/**
 * 登录
 */
class LoginActivity : BaseActivity() {
    var nextTag = false
    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    @SuppressLint("ResourceAsColor")
    override fun initView() {
        super.initView()
        tv_check_login.singleClick {
            tv_check_login.setTextColor(R.color.white)
            tv_check_register.setTextColor(R.color.black)
            tv_check_login.setBackgroundResource(R.drawable.shape_bg_circle_white)
            tv_check_register.setBackgroundColor(R.color.transparent)
            layout_password.visibility = View.VISIBLE
            layout_code.visibility = View.GONE
            tv_next.text = "登录"
            nextTag = false
        }
        tv_check_register.singleClick {
            tv_check_login.setTextColor(R.color.black)
            tv_check_register.setTextColor(R.color.white)
            tv_check_register.setBackgroundResource(R.drawable.shape_bg_circle_white)
            tv_check_login.setBackgroundColor(R.color.transparent)
            layout_password.visibility = View.GONE
            layout_code.visibility = View.VISIBLE
            tv_next.text = "下一步"
            nextTag = true
        }

        tv_next.singleClick {
            if (nextTag){
                register()
            }else{
                login()
            }
        }

    }

    /**
     * 登录
     */
    private fun login() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    /**
     * 注册
     */
    private fun register() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initData() {
        super.initData()

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
