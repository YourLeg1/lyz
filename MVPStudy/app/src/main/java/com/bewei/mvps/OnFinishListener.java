package com.bewei.mvps;

import com.bewei.mvps.model.News;

/**
 * 1. 类的用途 接口回调
 * 2. @author forever
 * 3. @date 2017/10/30 15:52
 */


public interface OnFinishListener {
    void onSuccess(News news);
}
