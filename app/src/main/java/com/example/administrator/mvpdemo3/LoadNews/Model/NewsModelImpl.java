package com.example.administrator.mvpdemo3.LoadNews.Model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/1/15.
 */

public class NewsModelImpl implements NewsModel {

    public static final String url1 = "http://www.163.com";

    @Override
    public void loadNewsFromNet(final OnLoadListener listener) {
        OkGo.get(url1).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                listener.onLoadSuccess(s);
            }

        });

    }


}
