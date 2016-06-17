package cc.guoxingnan.mvptest.modle;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cc.guoxingnan.mvptest.entity.Image;

/**
 * Created by mixinan on 2016/6/17.
 */
public class ModleImpl implements IModle {
    @Override
    public void getDataList(final CallBack callBack) {
        AsyncTask<String, String, List<Image>> task = new AsyncTask<String, String, List<Image>>() {
            @Override
            protected List<Image> doInBackground(String... params) {
                try {
                    URL url = new URL("http://gank.io/api/data/福利/10/1");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    InputStream is = conn.getInputStream();

                    StringBuilder sb = new StringBuilder();
                    String line = "";
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                    }

                    String json = sb.toString();

                    Log.i("Test", "doInBackground: " + json);

                    JSONObject obj = new JSONObject(json);
                    JSONArray array = obj.getJSONArray("results");

                    List<Image> data = new ArrayList<Image>();

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject o = array.getJSONObject(i);
                        String path = o.getString("url");
                        Image img = new Image();
                        img.setUrl(path);
                        data.add(img);
                    }
                    return data;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(List<Image> images) {
                super.onPostExecute(images);

                callBack.onDataLoaded(images);
            }
        };
        task.execute();
    }
}
