package cc.guoxingnan.mvptest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import cc.guoxingnan.mvptest.R;
import cc.guoxingnan.mvptest.entity.Image;

/**
 * Created by mixinan on 2016/6/17.
 */
public class MyAdapter extends BaseAdapter {
    private List<Image> data;
    private LayoutInflater inflater;
    private Context context;

    public MyAdapter(Context context, List<Image> data) {
        this.data = data;
        this.context=context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Image getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item,null);
            holder = new ViewHolder();
            holder.iv= (ImageView) convertView.findViewById(R.id.imageview);
            convertView.setTag(holder);
        }

        holder = (ViewHolder) convertView.getTag();

        Image image = getItem(position);

        Glide.with(context).load(image.getUrl()).into(holder.iv);
        return convertView;
    }

    class ViewHolder{
        ImageView iv;
    }
}
