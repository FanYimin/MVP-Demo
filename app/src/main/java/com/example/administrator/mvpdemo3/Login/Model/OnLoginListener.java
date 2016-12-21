package com.example.administrator.mvpdemo3.Login.Model;

/**
 * Created by Administrator on 2016/12/15.
 */
public interface OnLoginListener {

    void success(UserBean userBean);

    void failure();
}
