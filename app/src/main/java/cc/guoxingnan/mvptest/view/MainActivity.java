package cc.guoxingnan.mvptest.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import cc.guoxingnan.mvptest.R;
import cc.guoxingnan.mvptest.adapter.MyAdapter;
import cc.guoxingnan.mvptest.entity.Image;
import cc.guoxingnan.mvptest.presenter.IPresenter;
import cc.guoxingnan.mvptest.presenter.PresenterImpl;

public class MainActivity extends AppCompatActivity implements IView{
    private ListView lv;
    private MyAdapter adapter;
    private IPresenter presenter;
    private List<Image> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listview);

        presenter = new PresenterImpl(this);
        presenter.loadAllData();
    }

    @Override
    public void setData(List<Image> data) {
        this.data = data;
    }

    @Override
    public void showData() {
        adapter = new MyAdapter(this,data);
        lv.setAdapter(adapter);
    }
}
