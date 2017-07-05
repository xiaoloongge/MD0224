package com.atguigu.md0224;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void onClick(){


    }


    public void callPhone(View view) {

        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + "10086");
        intent.setData(data);
//        //第一个参数上下文，第二个参数是请求的权限
//        if (ActivityCompat.checkSelfPermission(this,
//                Manifest.permission.CALL_PHONE)
//                != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            //第一个参数是上下文，第二个参数是请求的权限 第三个参数请求的code值
//            ActivityCompat.requestPermissions(this,new String[]{
//                    Manifest.permission.CALL_PHONE
//            },1);
//            return;
//        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            //第一个参数是上下文，第二个参数是请求的权限 第三个参数请求的code值
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.CALL_PHONE
            }, 1);
            return;
        }
        startActivity(intent);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode==1){ //打电话的权限
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED){
                //不同意授权
                Toast.makeText(this, "没有授权", Toast.LENGTH_SHORT).show();
            }else{
                //同意授权
                Toast.makeText(this, "已授权", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
