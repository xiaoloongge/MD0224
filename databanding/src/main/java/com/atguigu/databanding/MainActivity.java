package com.atguigu.databanding;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.atguigu.databanding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //生成一个 布局全名称后加binding名称的对象
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this,R.layout.activity_main);
        final UserInfo userInfo = new UserInfo("小龙哥真帅");
        binding.setUserInfo(userInfo);

        binding.setStudent(new Student("小玲玲"));

        binding.aaa.setText("小龙哥太帅了");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                userInfo.setName("小圆圆");
            }
        },2000);

    }
}
