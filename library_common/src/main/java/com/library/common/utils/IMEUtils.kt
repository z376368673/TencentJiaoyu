
package com.orz.nb.plus.redpacket.utils

import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * 软键盘工具类
 *
 * @author orz.
 * @date 16/4/9.
 */
@TargetApi(Build.VERSION_CODES.CUPCAKE)
object IMEUtils {

    /**
     * 切换键盘显示/隐藏状态
     *
     * @param context
     */
    fun toggleSoftInput(context: Context) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    /**
     * 显示键盘
     *
     * @param context
     * @return
     */
    fun toggleSoftInputx(context: Context) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(0, InputMethodManager.SHOW_FORCED)
    }

    /**
     * 显示键盘
     *
     * @param view
     * @return
     */
    fun showSoftInput(view: View): Boolean {
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        return imm.showSoftInput(view, InputMethodManager.SHOW_FORCED)
    }

    fun showSoftInput(activity: Activity): Boolean {
        val view = activity.currentFocus
        if (view != null) {
            val imm = view.context.getSystemService(
                    Context.INPUT_METHOD_SERVICE) as InputMethodManager
            return imm.showSoftInput(view, InputMethodManager.SHOW_FORCED)
        }
        return false
    }

    /**
     * 隐藏键盘
     *
     * @param view
     * @return
     */
    fun hideSoftInputs(view: View): Boolean {
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        return imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun hideSoftInput(view: View?): Boolean {
        val imm = view?.context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        return imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }

    fun hideSoftInput(activity: Activity): Boolean {
        if (activity.currentFocus != null) {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            return imm.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0)
        }
        return false
    }

    /**
     * 判断键盘是否打开
     *
     * @param context
     * @return
     */
    fun isActive(context: Context): Boolean {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        return imm.isActive
    }


}
