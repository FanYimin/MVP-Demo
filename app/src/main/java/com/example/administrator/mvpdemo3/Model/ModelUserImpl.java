package com.example.administrator.mvpdemo3.Model;

/**
 * Created by Administrator on 2016/12/15.
 */

public class ModelUserImpl implements ModelUser{
    @Override
    public void login(String username, String password, OnLoginListener listener) {
        if (username.equals("fan") && password.equals("123")) {
            UserBean userBean = new UserBean();
            userBean.setUserName(username);
            userBean.setPassword(password);
            listener.success(userBean);
        } else {
            listener.failure();
        }
    }
}
