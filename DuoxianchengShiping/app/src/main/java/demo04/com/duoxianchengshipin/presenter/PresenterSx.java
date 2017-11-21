package demo04.com.duoxianchengshipin.presenter;

import demo04.com.duoxianchengshipin.OFLin;
import demo04.com.duoxianchengshipin.bean.NewsBean;
import demo04.com.duoxianchengshipin.model.ModelSx;
import demo04.com.duoxianchengshipin.model.Modelif;
import demo04.com.duoxianchengshipin.view.ViewShow;

/**
 * Created by 小可爱 on 2017/11/21.
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
        modelif.M(this);
    }

    @Override
    public void setData(NewsBean bean) {
        viewShow.show(bean);
    }
}
