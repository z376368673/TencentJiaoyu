package com.orz.nb.plus.redpacket.utils

import android.widget.Toast

/**
 * Toast工具类，解决多个Toast同时出现的问题
 *
 * @author orz.
 * @date 16/4/9.
 */
object ToastUtils {

    private var mToast: Toast? = null
    private val context = App.instance()

    /********************** 非连续弹出的Toast  */
    fun showSingleToast(resId: Int) { //R.string.**
        getSingleToast(resId, Toast.LENGTH_SHORT)!!.show()
    }

    fun showSingleToast(text: String) {
        getSingleToast(text, Toast.LENGTH_SHORT)!!.show()
    }

    fun showSingleLongToast(resId: Int) {
        getSingleToast(resId, Toast.LENGTH_LONG)!!.show()
    }

    fun showSingleLongToast(text: String) {
        getSingleToast(text, Toast.LENGTH_LONG)!!.show()
    }

    /*********************** 连续弹出的Toast  */
    fun showToast(resId: Int) {
        getToast(resId, Toast.LENGTH_SHORT).show()
    }

    fun showToast(text: String) {
        getToast(text, Toast.LENGTH_SHORT).show()
    }

    fun showLongToast(resId: Int) {
        getToast(resId, Toast.LENGTH_LONG).show()
    }

    fun showLongToast(text: String) {
        getToast(text, Toast.LENGTH_LONG).show()
    }

    private fun getSingleToast(resId: Int, duration: Int): Toast? { // 连续调用不会连续弹出，只是替换文本
        return getSingleToast(context.resources.getText(resId).toString(), duration)
    }

    private fun getSingleToast(text: String, duration: Int): Toast? {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, duration)
        } else {
            mToast!!.setText(text)
        }
        return mToast
    }

    private fun getToast(resId: Int, duration: Int): Toast { // 连续调用会连续弹出
        return getToast(context.resources.getText(resId).toString(), duration)
    }

    private fun getToast(text: String, duration: Int): Toast {
        return Toast.makeText(context, text, duration)
    }


}
