package cc.guoxingnan.mvptest.view;

import java.util.List;

import cc.guoxingnan.mvptest.entity.Image;

/**
 * Created by mixinan on 2016/6/17.
 */
public interface IView {
    public void setData(List<Image> data);
    public void showData();
}
