package com.example.administrator.myhappysky.launch;

import android.Manifest;;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.administrator.myhappysky.MainActivity;

import com.example.administrator.myhappysky.utils.JUtils;
import com.tbruyelle.rxpermissions.RxPermissions;

import rx.functions.Action1;

public class LaunchActivity extends AppCompatActivity {

    private final String TAG = "LaunchActivity";
    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_launcher);
        //btn = (Button) findViewById(R.id.btn);
        RxPermissions.getInstance(LaunchActivity.this)
                .request(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        if (aBoolean) {//true表示获取权限成功（注意这里在android6.0以下默认为true）
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent i = new Intent(LaunchActivity.this, MainActivity.class);
                                    startActivity(i);
                                    finish();
                                }
                            }, 1500);
                        } else {
                            JUtils.Toast("请开通SD卡读写权限");
                        }
                    }
                });
    }
}
