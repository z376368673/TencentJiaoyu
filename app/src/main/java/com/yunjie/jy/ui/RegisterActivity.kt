package com.yunjie.jy.ui

import android.annotation.SuppressLint
import android.text.TextUtils
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.library.common.https.HttpClient
import com.library.common.https.ResultBean
import com.library.common.https.ResultDataCallback
import com.orz.nb.plus.redpacket.utils.singleClick
import com.yunjie.jy.R
import com.yunjie.jy.api.API
import com.yunjie.jy.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.tv_next
import kotlinx.android.synthetic.main.activity_register.*


/**
 * 注册
 */
class RegisterActivity : BaseActivity() {

    var password1 = ""
    var password2 = ""

    override fun getLayoutId(): Int {
        return R.layout.activity_register
    }

    @SuppressLint("ResourceAsColor")
    override fun initView() {
        super.initView()
        tv_next.singleClick {
            register()
        }
        et_password1.addTextChangedListener {
            password1 = it.toString()
            if (password1.length>=6&&password2.length>=6){
                tv_next.alpha = 1f
            }else{
                tv_next.alpha = 0.5f
            }
        }
        et_password2.addTextChangedListener {
            password2 = it.toString()
            if (password1.length>=6&&password2.length>=6){
                tv_next.alpha = 1f
            }else{
                tv_next.alpha = 0.5f
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
