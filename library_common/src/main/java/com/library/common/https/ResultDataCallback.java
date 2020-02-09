package com.library.common.https;

import android.app.Activity;
import android.util.Log;
import com.alibaba.fastjson.JSON;

public abstract class ResultDataCallback implements ResultCallback {
    private static final String TAG = "http";
    Boolean isShow;
    public ResultDataCallback(Activity activity, boolean isShow){
        this.isShow = isShow;
    }
    @Override
    public void onStart() {
        Log.e(TAG, "onStart: ");
    }
    @Override
    public void onProgress(int progress) {

    }
    @Override
    public void onError(String error) {
        Log.e(TAG, "onError: "+error);
    }
    @Override
    public void onResult(String json, String url) {
        ResultBean resultBean = JSON.parseObject(json,ResultBean.class);
        resultBean.json = json;
        onResult(resultBean,resultBean.msg);
    }
    public abstract void onResult(ResultBean bean, String msg);

    @Override
    public void onFinish() {
        Log.e(TAG, "onFinish:");
    }
}
