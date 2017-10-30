package com.bewei.mvps.presenter;

import android.content.Context;

import com.bewei.mvps.OnFinishListener;
import com.bewei.mvps.model.News;
import com.bewei.mvps.model.ShowModel;
import com.bewei.mvps.model.ShowModelImpl;
import com.bewei.mvps.view.ShowView;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/10/30 15:38
 */


public class ShowPresenterImpl implements ShowPresenter,OnFinishListener {
    ShowView showView;
    private final ShowModel showModel;
  //初始化
    public ShowPresenterImpl(ShowView showView){
        this.showView  = showView;
        //多态
        showModel = new ShowModelImpl();


    }

    @Override
    public void relevance() {
        //p跟m关联
        showModel.getData(this);
    }

    @Override
    public void onSuccess(News news) {
        //关联view
     showView.showData(news);
    }
}
