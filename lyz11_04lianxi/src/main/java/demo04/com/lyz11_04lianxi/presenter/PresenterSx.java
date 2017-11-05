package demo04.com.lyz11_04lianxi.presenter;

import demo04.com.lyz11_04lianxi.OFLin;
import demo04.com.lyz11_04lianxi.bean.News;
import demo04.com.lyz11_04lianxi.model.ModelSx;
import demo04.com.lyz11_04lianxi.model.Modelif;
import demo04.com.lyz11_04lianxi.view.ViewShow;

/**
 * Created by 小可爱 on 2017/11/4.
 */

public class PresenterSx implements Presenterif,OFLin{
    private ViewShow viewShow;
    private final Modelif modelif;

    public PresenterSx(ViewShow viewShow) {
        this.viewShow = viewShow;
        modelif = new ModelSx();
    }

    @Override
    public void getData() {
        modelif.setData(this);
    }

    @Override
    public void Show(News news) {
        viewShow.ShowData(news);
    }
}
