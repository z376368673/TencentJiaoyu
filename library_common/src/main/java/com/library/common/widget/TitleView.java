package com.library.common.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.library.common.R;

/**
 * @author： zh浩
 * @创建时间:19-10-19 上午10:09
 * @描述： TitleView 统一设置标题栏
 * @更新时间： 19-10-19 上午10:09
 * @更新说明： 无
 * @版本号 1.0
 */
public class TitleView extends LinearLayout {
    private Context context;
    /**
     * 左边布局
     */
    private RelativeLayout layout_left;
    private ImageView iv_left;
    private TextView tv_left;
    /**
     * 标题
     */
    private TextView tv_content;
    /**
     * 右边布局
     */
    private LinearLayout layout_right;
    public ImageView iv_right;
    public TextView tv_right;

    public TitleView(Context context) {
        super(context);
        initView(context);
    }

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        this.context = context;
        /**
         * 初始化所有view
         */
        LayoutInflater.from(context).inflate(R.layout.view_title_layout, this);
        layout_left = findViewById(R.id.layout_left);
        iv_left = findViewById(R.id.iv_left);
        tv_left = findViewById(R.id.tv_left);

        tv_content = findViewById(R.id.tv_content);

        layout_right = findViewById(R.id.layout_right);
        iv_right = findViewById(R.id.iv_right);
        tv_right = findViewById(R.id.right_tv);


    }

    /**
     * 隐藏标题
     */
    public void hideTitle(){
       setVisibility(GONE);
    }

    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitleText(String title) {
        if (tv_content != null) {
            tv_content.setText(title);
        }
    }

    /**
     * 设置左边按钮监听
     *
     * @param onClickListener
     */
    public void setBackListener(OnClickListener onClickListener) {
        layout_left.setVisibility(VISIBLE);
        iv_left.setVisibility(VISIBLE);
        iv_left.setOnClickListener(onClickListener);
    }

    public void setBackListener() {
        setBackListener(v -> {
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        });
    }

    /**
     * 设置右边 图片 + 点击
     *
     * @param imgId
     * @param clickListener
     */
    public void setRightImg(int imgId, OnClickListener clickListener) {
        layout_right.setVisibility(VISIBLE);
        iv_right.setVisibility(VISIBLE);
        iv_right.setImageResource(imgId);
        iv_right.setOnClickListener(clickListener);
    }

    /**
     * 设置右边 图片
     *
     * @param imgId
     */
    public void setRightImg(int imgId) {
        layout_right.setVisibility(VISIBLE);
        iv_right.setVisibility(VISIBLE);
        iv_right.setImageResource(imgId);
    }

    /**
     * 设置右边 文字
     *
     * @param text
     */
    public void setRightTv(String text) {
        layout_right.setVisibility(VISIBLE);
        tv_right.setVisibility(VISIBLE);
        tv_right.setText(text);
    }

    /**
     * 设置右边 文字 + 点击
     *
     * @param text
     * @param clickListener
     */
    public void setRightTv(String text, OnClickListener clickListener) {
        layout_right.setVisibility(VISIBLE);
        tv_right.setVisibility(VISIBLE);
        tv_right.setText(text);
        tv_right.setOnClickListener(clickListener);
    }

    public ImageView getRightImageView() {
        layout_right.setVisibility(VISIBLE);
        iv_right.setVisibility(VISIBLE);
        return iv_right;
    }

    /**
     * 隐藏左边布局
     */
    public void goneLeftLayout(boolean isGone) {
        if (isGone){
            layout_left.setVisibility(GONE);
        }else {
            layout_left.setVisibility(VISIBLE);
        }

    }

    /**
     * 隐藏左边布局
     */
    public void goneRightLayout(boolean isGone) {
        if (isGone){
            layout_right.setVisibility(GONE);
        }else {
            layout_right.setVisibility(VISIBLE);
        }

    }
}
