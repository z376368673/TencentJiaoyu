package com.orz.nb.plus.redpacket.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Orz on 2020/1/13.
 * Describe:
 */
object AppUtils {
    /* 获取app的版本信息 */
    fun getVersionCode(): Int {
        val context = App.instance()
        val manager = context.packageManager
        try {
            val packageInfo = manager.getPackageInfo(context.packageName, 0)
            return packageInfo.versionCode// 系统版本号
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        return 0
    }

    fun getVersionName(): String {
        val context = App.instance()
        val manager = context.packageManager
        try {
            val packageInfo = manager.getPackageInfo(context.packageName, 0)
            return packageInfo.versionName// 系统版本名
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        return ""
    }

    fun getResouse():Resources{
        val context = App.instance()
       return context.resources
    }

    /**
     * 实现文本复制到剪切板功能
     * @param str
     *
     * 复制成功返回true
     */
    fun copy(str: String, context: Context):Boolean{
        // 得到剪贴板管理器
        val clipboard = context.getSystemService(AppCompatActivity.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Label", str)
        clipboard.setPrimaryClip(clip)
        return clipboard.hasPrimaryClip()
    }

    /**
     * 实现粘贴功能
     * @param context
     * @return
     */
    fun paste(context: Context): String {
        // 得到剪贴板管理器
        val cmb = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        return  cmb.text.toString().trim { it <= ' ' }
    }

}
