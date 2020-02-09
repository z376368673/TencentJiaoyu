package com.orz.nb.plus.redpacket.utils

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView

import java.util.ArrayList

/**
 * Created by cxd on 2020/1/8
 * Describe: 监听多个edit来改变button是否可点击
 */
class EditTextUtil
/**
 * 构造函数
 *
 * @param view    跟随EditText或者TextView输入为空来判断启动或者禁用这个View
 * @param alpha    是否需要设置透明度
 */
@JvmOverloads constructor(
    private val mMainView: View?//操作按钮的View
    , private val isAlpha: Boolean = true//是否设置透明度
) : TextWatcher {
    private var mViewSet: MutableList<TextView>? = null//TextView集合，子类也可以（EditText、TextView、Button）

    init {
        requireNotNull(mMainView) { "The view is empty" }
    }

    /**
     * 添加EditText或者TextView监听
     *
     * @param views  传入单个或者多个EditText或者TextView对象
     */
    fun addViews(vararg views: TextView) {
        if (views == null) return

        if (mViewSet == null) {
            mViewSet = ArrayList(views.size - 1)
        }

        for (view in views) {
            view.addTextChangedListener(this)
            mViewSet!!.add(view)
        }
        afterTextChanged(null)
    }

    /**
     * 移除EditText监听，避免内存泄露
     */
    fun removeViews() {
        if (mViewSet == null) return

        for (view in mViewSet!!) {
            view.removeTextChangedListener(this)
        }
        mViewSet!!.clear()
        mViewSet = null
    }

    // TextWatcher

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

    @Synchronized
    override fun afterTextChanged(s: Editable?) {
        if (mViewSet == null) return

        for (view in mViewSet!!) {
            if ("" == view.text.toString()) {
                setEnabled(false)
                return
            }
        }

        setEnabled(true)
    }

    /**
     * 设置View的事件
     *
     * @param enabled    启用或者禁用View的事件
     */
    fun setEnabled(enabled: Boolean) {
        if(enabled == mMainView?.isEnabled) return

        if (enabled) {
            //启用View的事件
            mMainView?.setEnabled(true)
            if (isAlpha) {
                //设置不透明
                mMainView?.setAlpha(1f)
            }
        } else {
            //禁用View的事件
            mMainView?.setEnabled(false)
            if (isAlpha) {
                //设置半透明
                mMainView?.setAlpha(0.5f)
            }
        }
    }


}
