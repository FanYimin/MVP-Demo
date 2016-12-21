package com.example.administrator.mvpdemo3.LoadNews.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.administrator.mvpdemo3.LoadNews.Presneter.NewsPresenter;
import com.example.administrator.mvpdemo3.LoadNews.Presneter.NewsPresenterImpl;
import com.example.administrator.mvpdemo3.R;


/**
 * A login screen that offers login via email/password.
 */
public class MainActivity extends AppCompatActivity implements NewsView {
    TextView textView;
    NewsPresenter newsPresenter;
    String TAG = "main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        textView = (TextView) findViewById(R.id.text);
        newsPresenter = new NewsPresenterImpl( this);
        newsPresenter.showNews();

    }

    @Override
    public void showNewsDetail(String str) {
        Log.i(TAG, "showNewsDetail: "+str);
        textView.setText(str);
    }
}

