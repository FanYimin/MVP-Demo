package com.example.administrator.mvpdemo3.Login.View;

/**
 * Created by Administrator on 2016/12/15.
 */

public interface LoginView {

    String getUsername();

    String getPassword();

    void loginSuccess();

    void loginFailure();

    void clear();
}
