package com.example.administrator.mvpdemo3.LoadNews.Presneter;


import com.example.administrator.mvpdemo3.LoadNews.Model.NewsModel;
import com.example.administrator.mvpdemo3.LoadNews.Model.NewsModelImpl;
import com.example.administrator.mvpdemo3.LoadNews.Model.OnLoadListener;
import com.example.administrator.mvpdemo3.LoadNews.View.NewsView;

/**
 * Created by Administrator on 2016/12/15.
 */

public class NewsPresenterImpl implements NewsPresenter, OnLoadListener {
    NewsModel newsModel;
    NewsView newsView;

    public NewsPresenterImpl(  NewsView newsView) {

        this.newsView = newsView;
        newsModel = new NewsModelImpl();
    }

    @Override
    public void showNews() {
        newsModel.loadNewsFromNet(this);
    }

    @Override
    public void onLoadSuccess(String s) {
        newsView.showNewsDetail(s);
    }

    @Override
    public void onLoadFailure() {
        newsView.showNewsDetail("fail");
    }
}
