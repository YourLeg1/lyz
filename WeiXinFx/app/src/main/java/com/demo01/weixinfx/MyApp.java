package com.demo01.weixinfx;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;

/**
 * Created by 小可爱 on 2017/10/10.
 */

public class MyApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        //AppID必须填对
        PlatformConfig.setWeixin("","");
    }
}
