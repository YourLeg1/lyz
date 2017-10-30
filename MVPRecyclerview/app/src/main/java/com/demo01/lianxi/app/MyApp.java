package com.demo01.lianxi.app;

import android.app.Application;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/9/8 12:33
 */

public class MyApp extends Application {
    public static MyApp mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        String path = Environment.getExternalStorageDirectory()+"/en";

        File cacheDir = new File(path);

        //没有网的情况，首先回去内存找图片, 如果内存不存在次张图片的话，去sdcard，->去网络加载
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                //配置线程的优先级，图片加载为首
                .threadPriority(100)
                //指定由多个线程去加载图片
                .threadPoolSize(5)
                //指定要缓存多大尺寸的图片(内存缓存)
                .memoryCacheExtraOptions(200,200)
                //配置sdcard缓存路径
                .diskCache(new UnlimitedDiskCache(cacheDir))
                //指定图片的名字，根据MD5算出来的一个串号(串号不会重名)
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                //指明图片在内存占用多大空间(APP默认空间1/8)
                .memoryCacheSize(2 * 1024 * 1024)
                //指定图片在sdcard缓存多大(指的是占用空间)
                .diskCacheSize(50 * 1024 * 1024)
                .build();


        ImageLoader.getInstance().init(config);

    }
    public static MyApp getInstance() {
        return mInstance;
    }
}
