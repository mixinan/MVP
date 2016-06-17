package cc.guoxingnan.mvptest.modle;

import java.util.List;

import cc.guoxingnan.mvptest.entity.Image;

/**
 * Created by mixinan on 2016/6/17.
 */
public interface CallBack {
    public void onDataLoaded(List<Image> data);
}
