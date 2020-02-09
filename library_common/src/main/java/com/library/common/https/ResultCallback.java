package com.library.common.https;

public interface ResultCallback {
    /**
     * 开始回调
     */
     void onStart();

    /**
     * 成功回调
     * @param json
     */
    void onResult(String json, String url);

    /**
     * 进度回调
     * @param progress
     */
     void onProgress(int progress);

    /**
     * 错误回调
     * @param error
     */
    void onError(String error);
    /**
     * 回调
     */
     void onFinish();
}