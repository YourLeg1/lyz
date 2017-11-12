package demo04.com.lyz11_11lianxi.presenter;

import demo04.com.lyz11_11lianxi.OFLin;
import demo04.com.lyz11_11lianxi.bean.News;
import demo04.com.lyz11_11lianxi.model.ModelSx;
import demo04.com.lyz11_11lianxi.model.Modelif;
import demo04.com.lyz11_11lianxi.view.ViewShow;

/**
 * Created by 小可爱 on 2017/11/11.
 */

public class PresenterSx implements Presenterif,OFLin{
    private ViewShow viewShow;
    private final Modelif modelif;

    public PresenterSx(ViewShow viewShow) {
        this.viewShow = viewShow;
        modelif = new ModelSx();
    }

    @Override
    public void r() {
        modelif.setData(this);
    }

    @Override
    public void getData(News news) {
        viewShow.ShowView(news);
    }
}
