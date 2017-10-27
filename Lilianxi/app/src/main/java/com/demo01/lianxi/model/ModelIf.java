package com.demo01.lianxi.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.demo01.lianxi.view.ViewListener;

/**
 * Created by 小可爱 on 2017/10/27.
 */

public interface ModelIf {
    void modelIf(Context context, RecyclerView recyclerView, ViewListener listener);
}
