package com.yunjie.jy.ui.fragment

import android.os.Bundle
import android.view.View
import com.yunjie.jy.R
import com.yunjie.jy.base.BaseFragment

class GrowUpFragment : BaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_grow_up
    }
    override fun initView(view: View) {
        super.initView(view)

    }

    override fun initEvent() {
        super.initEvent()
    }

    override fun initData() {
        super.initData()
    }

    companion object {
        fun newInstance(title: String): GrowUpFragment {
            val args = Bundle()
            args.putString("title", title)
            val fragment = GrowUpFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
