package cc.guoxingnan.mvptest.presenter;

import java.util.List;

import cc.guoxingnan.mvptest.entity.Image;
import cc.guoxingnan.mvptest.modle.CallBack;
import cc.guoxingnan.mvptest.modle.IModle;
import cc.guoxingnan.mvptest.modle.ModleImpl;
import cc.guoxingnan.mvptest.view.IView;

/**
 * Created by mixinan on 2016/6/17.
 */
public class PresenterImpl implements IPresenter {
    private IView view;
    private IModle modle;

    public PresenterImpl(IView view) {
        this.view = view;
        modle = new ModleImpl();
    }

    @Override
    public void loadAllData() {
        modle.getDataList(new CallBack() {
            @Override
            public void onDataLoaded(List<Image> data) {
                view.setData(data);
                view.showData();
            }
        });
    }
}
