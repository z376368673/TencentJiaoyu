package com.library.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * @author： zh浩
 * @创建时间:19-10-22$ 下午3:53$
 * @描述： Activity 工具类
 * @更新时间： 19-10-22$ 下午3:53$
 * @更新说明： 无
 * @版本号 1.0
 */
public class ActivityUtlis {

    private static ActivityUtlis activityUtlis;
    private Context mContext;

    public static ActivityUtlis getInstance(Context context) {
        if (activityUtlis == null) {
            activityUtlis = new ActivityUtlis(context);
        }
        return activityUtlis;
    }

    private ActivityUtlis(Context context) {
        this.mContext = context;
    }

    public void startActivity(Class clasAct) {
        Intent intent = new Intent(mContext, clasAct);
        mContext.startActivity(intent);
    }

    public void startActivity(Class clasAct, String key, String value) {
        Intent intent = new Intent(mContext, clasAct);
        intent.putExtra(key, value);
        mContext.startActivity(intent);
    }

    public void startActivity(Class clasAct, String key, int value) {
        Intent intent = new Intent(mContext, clasAct);
        intent.putExtra(key, value);
        mContext.startActivity(intent);
    }

    public void startActivity(Class clasAct, Bundle bundle) {
        Intent intent = new Intent(mContext, clasAct);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }


    public void startActivity(Class clasAct, Serializable serializable) {
        Intent intent = new Intent(mContext, clasAct);
        Bundle bundle = new Bundle();
        bundle.putSerializable("serializable", serializable);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }


    public void startActivity(Class clasAct, String action) {
        Intent intent = new Intent(mContext, clasAct);
        intent.setAction(action);
        mContext.startActivity(intent);
    }

    public void startActivity(Class clasAct, Parcelable parcelable) {
        Intent intent = new Intent(mContext, clasAct);
        Bundle bundle = new Bundle();
        bundle.putParcelable("parcelable", parcelable);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }


    public static <T extends Serializable> T getSerializable(Activity activity, Class<T> tClass) {
        Bundle bundle = activity.getIntent().getExtras();
        T data = null;
        try {
            if (bundle != null) {
                data = (T) bundle.getSerializable("serializable");
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return data;
    }

    public <T> T getParcelable(Activity activity, Class<T> tClass) {
        Bundle bundle = activity.getIntent().getExtras();
        T data = null;
        try {
            if (bundle != null) {
                data = bundle.getParcelable("parcelable");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }


}
