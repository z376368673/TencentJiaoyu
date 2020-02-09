package com.yunjie.jy;

import com.library.common.App;
import com.library.common.https.HttpClient;

public class MainApp extends App {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpClient.getIntens("");
    }
}
