package com.yunjie.jy.ui.adapter;

import androidx.annotation.NonNull;
import com.chad.library.adapter.base.BaseViewHolder;
import com.library.common.base.adapter.BaseSingleAdapter;
import com.yunjie.jy.R;

import java.util.ArrayList;

public class HomeChatAdapter extends BaseSingleAdapter<String,BaseViewHolder> {

    public HomeChatAdapter() {
        super(R.layout.item_home_chat,new ArrayList<>());
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {

    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {

    }
}
