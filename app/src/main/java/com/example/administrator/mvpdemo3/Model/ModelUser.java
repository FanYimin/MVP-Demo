package com.example.administrator.mvpdemo3.Model;

/**
 * Created by Administrator on 2016/12/15.
 */

public interface ModelUser {
    void login(String username, String password, OnLoginListener listener);
}
