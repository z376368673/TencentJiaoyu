package com.yunjie.jy.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.yunjie.jy.R
import com.yunjie.jy.base.BaseFragment
import com.yunjie.jy.ui.adapter.HomeChatAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment(){

    private val adapter:HomeChatAdapter by lazy { HomeChatAdapter() }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initView(view: View) {
        super.initView(view)
        refreshLayout.setOnRefreshLoadMoreListener(this)
        recyclerView.layoutManager = LinearLayoutManager(mContext)
        recyclerView.adapter = adapter
    }

    override fun initEvent() {
        super.initEvent()
    }

    override fun initData() {
        super.initData()
        adapter.addData("1111111111")
        adapter.addData("1111111111")
        adapter.addData("1111111111")
        adapter.addData("1111111111")
        adapter.addData("1111111111")
        adapter.addData("1111111111")
    }

    companion object {
        fun newInstance(title: String): HomeFragment {
            val args = Bundle()
            args.putString("title", title)
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
