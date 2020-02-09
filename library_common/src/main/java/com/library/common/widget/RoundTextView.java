package com.library.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.library.common.R;

/**
 * Created by Orz on 2019/10/22.
 * Describe: RoundTextView
 */
public class RoundTextView extends AppCompatTextView {



    private int mBgColor;

    private int mCornerRadius;

    private Paint mPaint;



    public RoundTextView(Context context) {

        super(context);

        init(context, null);

    }



    public RoundTextView(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);

        init(context, attrs);

    }



    public RoundTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);

        init(context, attrs);

    }



    private void init(Context context, AttributeSet attributeSet) {

        try {

            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.RoundTextView);

            mBgColor = typedArray.getColor(R.styleable.RoundTextView_backgroundColor,

                    getResources().getColor(R.color.white));

            mCornerRadius = typedArray.getDimensionPixelSize(R.styleable.RoundTextView_cornerRadius,10);

            mPaint = new Paint(Paint.FILTER_BITMAP_FLAG);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }



    @Override

    protected void onDraw(Canvas canvas) {

        if (this.getMeasuredWidth() <= 0 || this.getMeasuredHeight() <= 0) {

            return;

        }

        mPaint.setAntiAlias(true);

        mPaint.setColor(mBgColor);



        RectF rectF = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());

        canvas.drawRoundRect(rectF, mCornerRadius, mCornerRadius, mPaint);

        super.onDraw(canvas);

    }



    public void setBgCornerRadius(int radius) {

        mCornerRadius = radius;

        invalidate();

    }



    public void setBgColor(int color) {

        mBgColor = color;

        invalidate();

    }

}
