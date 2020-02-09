package com.yunjie.jy.ui.fragment

import android.os.Bundle
import android.view.View
import com.yunjie.jy.R
import com.yunjie.jy.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_demo.*

class OurFragment : BaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_our
    }

    override fun initView(view: View) {
        super.initView(view)
        tv_content?.text = arguments?.getString("title")
    }

    override fun initEvent() {
        super.initEvent()
    }

    override fun initData() {
        super.initData()
    }

    companion object {
        fun newInstance(title: String): OurFragment {
            val args = Bundle()
            args.putString("title", title)
            val fragment = OurFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
