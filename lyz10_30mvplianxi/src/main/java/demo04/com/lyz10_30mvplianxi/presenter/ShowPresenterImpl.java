package demo04.com.lyz10_30mvplianxi.presenter;

import demo04.com.lyz10_30mvplianxi.OnFinishListener;
import demo04.com.lyz10_30mvplianxi.bean.Bean;
import demo04.com.lyz10_30mvplianxi.model.ShowModel;
import demo04.com.lyz10_30mvplianxi.model.ShowModelImpl;
import demo04.com.lyz10_30mvplianxi.view.ShowView;

/**
 * Created by 小可爱 on 2017/10/30.
 */

public class ShowPresenterImpl implements ShowPresenter,OnFinishListener{
    ShowView showView;
    private final ShowModel showModel;

    public ShowPresenterImpl(ShowView showView) {
        this.showView = showView;
        showModel = new ShowModelImpl();
    }

    @Override
    public void relevance() {
        //p跟m关联
        showModel.getData(this);
    }

    @Override
    public void onSuccess(Bean bean) {
        //关联view
        showView.ShowData(bean);
    }
}
