package com.atguigu.md0224;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final TextInputLayout tlpwd = (TextInputLayout) findViewById(R.id.tl_pwd);
        final TextInputLayout tlusername = (TextInputLayout)findViewById(R.id.tl_username);
        final EditText etusername = (EditText) findViewById(R.id.et_username);
        final EditText etpassword = (EditText) findViewById(R.id.et_pwd);
        Button login = (Button) findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(etusername.getText().toString())){
                    tlusername.setErrorEnabled(true);
                    tlusername.setError("用户名不能为空");
                    etusername.requestFocus(); //获取焦点
                }else{
                    tlusername.setErrorEnabled(false);
                }

                if (TextUtils.isEmpty(etpassword.getText().toString())){
                    tlpwd.setErrorEnabled(true);
                    tlpwd.setError("密码不能为空");
                    etpassword.requestFocus(); //获取焦点
                }else{
                    tlpwd.setErrorEnabled(false);
                }

            }
        });

    }
}
