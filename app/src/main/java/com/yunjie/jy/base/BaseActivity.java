package com.yunjie.jy.base;

import android.graphics.Color;
import androidx.annotation.NonNull;
import com.library.common.base.LibBaseActivity;
import com.library.common.utils.UBarUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

public class BaseActivity extends LibBaseActivity implements OnRefreshLoadMoreListener {

    @Override
    protected void initStatusBar() {
        super.initStatusBar();
        UBarUtil.setNavBarImmersive(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }
    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        refreshLayout.finishLoadMore();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        refreshLayout.finishRefresh();

    }
}
