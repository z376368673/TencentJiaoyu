package com.library.common.base.adapter;
import androidx.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： zh浩
 * 
 * @创建时间:19-10-16 下午3:19
 * 
 * @描述：   用了鸿翔大牛的BaseQuickAdapter 这里只是做了一层封装 以便于扩展
 * 
 * @更新时间： 19-10-16 下午3:19
 * 
 * @更新说明： 无
 * 
 * @版本号 1.0
 */
public abstract class BaseSingleAdapter<Data,Holder extends BaseViewHolder> extends BaseQuickAdapter<Data,Holder> {

    public BaseSingleAdapter(){
        super(0,new ArrayList<>());
    }

    public BaseSingleAdapter(int id, @Nullable List<Data> data) {
        super(id,data);
    }

    public BaseSingleAdapter(@Nullable List<Data> data) {
        super(data);
    }


}
