package com.example.administrator.mvpdemo3.Presenter;

import com.example.administrator.mvpdemo3.Model.ModelUser;
import com.example.administrator.mvpdemo3.Model.ModelUserImpl;
import com.example.administrator.mvpdemo3.Model.OnLoginListener;
import com.example.administrator.mvpdemo3.Model.UserBean;
import com.example.administrator.mvpdemo3.View.LoginView;

/**
 * Created by Administrator on 2016/12/15.
 */

public class LoginPresenter implements  OnLoginListener {

    ModelUser modelUser;
    LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        modelUser = new ModelUserImpl();
        this.loginView = loginView;

    }

    public void login() {//登录方法
            modelUser.login(loginView.getUsername(), loginView.getPassword(), this);
    }

    public void clear() {
        loginView.clear();
    }

    @Override
    public void success(UserBean userBean) {
        loginView.loginSuccess();
    }

    @Override
    public void failure() {
        loginView.loginFailure();
    }
}
