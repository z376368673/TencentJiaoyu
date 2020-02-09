package com.yunjie.jy.ui.fragment

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.orz.nb.plus.redpacket.utils.singleClick
import com.yunjie.jy.R
import com.yunjie.jy.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_demo.*
import kotlinx.android.synthetic.main.fragment_detebase.*

class DatabaseFragment : BaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_detebase
    }

    override fun initView(view: View) {
        super.initView(view)
    }

    override fun initEvent() {
        super.initEvent()
        layout_data_sq.singleClick {
            checkItemBy(layout_data_sq,true);
            checkItemBy(layout_data_yp,false);
            checkItemBy(layout_data_ku,false);
        }
        layout_data_yp.singleClick {
            checkItemBy(layout_data_sq,false);
            checkItemBy(layout_data_yp,true);
            checkItemBy(layout_data_ku,false);
        }
        layout_data_ku.singleClick {
            checkItemBy(layout_data_sq,false);
            checkItemBy(layout_data_yp,false);
            checkItemBy(layout_data_ku,true);
        }
    }

    fun checkItemBy(layout: LinearLayout, checked: Boolean) {
        for (index in 1..layout.childCount) {
            val view = layout.getChildAt(index - 1)
            if (view is TextView) {
                if (checked) {
                    view.setTextColor(Color.parseColor("#ffffff"))
                    view.typeface = Typeface.DEFAULT_BOLD
                } else {
                    view.setTextColor(Color.parseColor("#f8f8f8"))
                    view.typeface = Typeface.DEFAULT
                }
            }

            if (view is ImageView) {
                if (checked) {
                    view.visibility = View.VISIBLE
                } else {
                    view.visibility = View.INVISIBLE
                }
            }
        }
    }

    override fun initData() {
        super.initData()
    }

    companion object {
        fun newInstance(title: String): DatabaseFragment {
            val args = Bundle()
            args.putString("title", title)
            val fragment = DatabaseFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
