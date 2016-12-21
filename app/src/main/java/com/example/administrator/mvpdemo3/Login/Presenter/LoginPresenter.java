package com.example.administrator.mvpdemo3.Login.Presenter;

import com.example.administrator.mvpdemo3.Login.Model.ModelUser;
import com.example.administrator.mvpdemo3.Login.Model.ModelUserImpl;
import com.example.administrator.mvpdemo3.Login.Model.OnLoginListener;
import com.example.administrator.mvpdemo3.Login.Model.UserBean;
import com.example.administrator.mvpdemo3.Login.View.LoginView;

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
