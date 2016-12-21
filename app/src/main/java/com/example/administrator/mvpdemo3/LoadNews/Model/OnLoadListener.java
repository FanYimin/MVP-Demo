package com.example.administrator.mvpdemo3.LoadNews.Model;

/**
 * Created by Administrator on 2016/12/15.
 */

public interface OnLoadListener {
    void onLoadSuccess(String str);

    void onLoadFailure();
}
