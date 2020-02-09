package com.library.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.library.common.R;

/**
 * @描述： (空数据view)  无网络
 * @创建时间:2019-12-17 15:12
 * @更新时间： 2019-12-17 15:12
 * @更新说明： 无
 * @author： zh浩
 * @版本号 1.0
 */
public class EmptyDataView extends LinearLayout {
    private Context context;

    private ImageView iv_empty;
    private TextView tv_empty_text;

    public EmptyDataView(Context context) {
        super(context);
        initView(context,null);
    }

    public EmptyDataView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    private void initView(Context context,AttributeSet attrs) {
        this.context = context;
        /**
         * 初始化所有view
         */
        LayoutInflater.from(context).inflate(R.layout.view_empty_layout, this);
        iv_empty = findViewById(R.id.iv_empty);
        tv_empty_text = findViewById(R.id.tv_empty_text);

        /**
         * 初始化Attribute
         */
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.EmptyDataView);
            String tips_text = typedArray.getString(R.styleable.EmptyDataView_tips_text);
            int tips_img = typedArray.getInt(R.styleable.EmptyDataView_tips_img,R.mipmap.pic_empty);
            tv_empty_text.setText(tips_text);
            iv_empty.setImageResource(tips_img);
        }

    }

    /**
     * 设置提示文字文字
     *
     * @param tipsText
     */
    public void setTipsText(String tipsText) {
        if (tv_empty_text != null) {
            tv_empty_text.setText(tipsText);
        }
    }

    /**
     * 设置 空数据图片
     *
     * @param ids
     */
    public void setTipsImg(int ids) {
        if (iv_empty != null) {
            iv_empty.setImageResource(ids);
        }
    }

}
