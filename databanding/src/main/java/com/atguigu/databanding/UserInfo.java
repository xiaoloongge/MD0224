package com.atguigu.databanding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Administrator on 2017/7/5.
 */

public class UserInfo extends BaseObservable {

    private String name;
    private int age;

    public UserInfo(String name) {
        this.name = name;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyChange();
    }

    @Bindable
    public int getAge() {
        return age;

    }

    public void setAge(int age) {
        this.age = age;
        notifyChange();
    }
}
