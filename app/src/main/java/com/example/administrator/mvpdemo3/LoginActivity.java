package com.example.administrator.mvpdemo3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.mvpdemo3.Presenter.LoginPresenter;
import com.example.administrator.mvpdemo3.View.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView {
    EditText etName, etPass;
    Button btLogin, btClear;
    LoginPresenter loginPresenter;
    String TAG = "main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etName = (EditText) findViewById(R.id.name);
        etPass = (EditText) findViewById(R.id.pass);
        btLogin = (Button) findViewById(R.id.login);
        btClear = (Button) findViewById(R.id.clear);

        loginPresenter = new LoginPresenter(this);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.login();
            }
        });
        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.clear();
            }
        });
    }

    @Override
    public String getUsername() {
        Log.i(TAG, "getUsername: " + etName.getText().toString());
        return etName.getText().toString();
    }

    public String getPassword() {
        return etPass.getText().toString();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailure() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void clear() {
        etName.setText("");
        etPass.setText("");
    }
}
