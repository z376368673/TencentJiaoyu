package com.library.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.library.common.R;

/**
 *  @描述：  自定义 RecyclerView  当没有数据时 显示一个 图片 和 文字
 *
 * @创建时间:2019-12-17 16:22
 *
 * @更新时间： 2019-12-17 16:22
 *
 * @更新说明： 无
 *
 * @author： zh浩
 *
 * @版本号 1.0
 */
public class RecyclerViews extends RecyclerView {
    private LoadData loadData; //
    private boolean complete;
    private Bitmap bitmap;
    private Paint paint;
    private String tipsText = "暂无数据";

    public RecyclerViews(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setTextSize(context.getResources().getDimension(R.dimen.sp_14));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(Color.BLACK);
    }

    public void setLoadData(LoadData loadData) {
        this.loadData = loadData;
    }

    /**
     * 设置提示文字
     * @param tipsText
     */
    public void setTipsText(String tipsText) {
        this.tipsText = tipsText;
    }
    /**
     * 设置图片
     * @param bitmap
     */
    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void completeLoad() {
        complete = true;
        invalidate(); //重绘
    }

    /**
     * 绘制图片 和 提示文字
     * @param canvas
     */
    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (getChildCount() == 0 && complete) {
            int x = (getWidth() - bitmap.getWidth()) / 2;
            int y = (getHeight() - bitmap.getHeight()) / 4;
            canvas.drawBitmap(bitmap, x, y, paint);
            canvas.drawText(tipsText, getWidth() / 2,
                    (getHeight() / 4) + bitmap.getHeight(),
                    paint);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
                if (getChildCount() == 0 && this.loadData != null) {
                    loadData.loadData();
                    return true;
                }
        }
        return super.dispatchTouchEvent(ev);
    }

    public interface LoadData {
        void loadData();
    }
}
