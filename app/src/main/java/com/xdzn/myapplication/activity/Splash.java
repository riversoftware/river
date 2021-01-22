package com.xdzn.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.xdzn.myapplication.MainActivity;
import com.xdzn.myapplication.R;

import java.util.Timer;
import java.util.TimerTask;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Timer timer = new Timer();
        timer.schedule(timetast,2000);

        Bmob.initialize(this,"451781d8e287ad540fff08f3e016072d");

    }

    TimerTask timetast = new TimerTask() {
        @Override
        public void run() {
        //startActivity(new Intent(Splash.this, MainActivity.class));

            BmobUser bmobUser = BmobUser.getCurrentUser(BmobUser.class);
            if(bmobUser!=null) {
                startActivity(new Intent(Splash.this, MainActivity.class));
                finish();
            }else {
                startActivity(new Intent(Splash.this, Login.class));
                finish();
            }

        }
    };
}
