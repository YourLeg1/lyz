package com.demo01.lianxi.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.demo01.lianxi.model.ModelIf;
import com.demo01.lianxi.model.ModelImpl;
import com.demo01.lianxi.view.ViewIf;
import com.demo01.lianxi.view.ViewListener;

/**
 * Created by 小可爱 on 2017/10/27.
 */
//P层
public class PresenterImpl implements PresenterIf,ViewListener{
    ViewIf viewIf;
    private final ModelIf modelIf;

    public PresenterImpl(ViewIf viewIf) {
        this.viewIf = viewIf;
        modelIf = new ModelImpl();
    }

    @Override
    public void validatepass(Context ctx, RecyclerView rlv) {
        modelIf.modelIf(ctx,rlv,this);
    }

    @Override
    public void onSuccess() {
        if(viewIf != null){
            viewIf.isSeccess();
        }
    }

    @Override
    public void unSuccessful() {
        if(viewIf != null){
            viewIf.isUnSeccess();
        }
    }
}
