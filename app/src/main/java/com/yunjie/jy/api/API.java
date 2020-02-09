package com.yunjie.jy.api;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface API {
    //http://192.168.0.26/

    /**
     * 文件上传
     */
    @POST("file/upFile")
    Call<ResponseBody> upFileSingle(@Body MultipartBody multipartBody);
//    // 上传单一文件
//    String des = "a image";
//    RequestBody description = RequestBody.create( MediaType.parse("multipart/form-data"), des);
//
//    RequestBody requestFile = RequestBody.create(MediaType.parse("text/plain"), new File("/sdcard/0/test.jpg"));
//    MultipartBody.Part body = MultipartBody.Part.createFormData("image", file.getName(), requestFile);
//    Call<String> call = fileUpload.uploadFile(description, body);

    //用户发送验证码接口
    @POST("user/sendSms?")
    Call<ResponseBody> sendSms(@Query("mobile") String mobile);



}
