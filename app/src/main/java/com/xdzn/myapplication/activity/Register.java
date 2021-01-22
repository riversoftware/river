package com.xdzn.myapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.xdzn.myapplication.Bean.User;
import com.xdzn.myapplication.R;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class Register extends AppCompatActivity {

    private EditText regUserName,regPassWord,nickName;
    private Button queDing;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regUserName = findViewById(R.id.regUserName);
        regPassWord = findViewById(R.id.regPassWord);
        nickName = findViewById(R.id.nickname);
        queDing = findViewById(R.id.queding);

        queDing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setUsername(regUserName.getText().toString().trim());
                user.setPassword(regPassWord.getText().toString().trim());
                user.setNickname(nickName.getText().toString().trim());

                if(regUserName.getText().toString().equals("")) {

                    Toast.makeText(Register.this, "请输入用户名", Toast.LENGTH_SHORT).show();

                }else if(regPassWord.getText().toString().equals("")) {

                    Toast.makeText(Register.this, "请输入密码", Toast.LENGTH_SHORT).show();

                }else {

                    user.signUp(new SaveListener<User>() {
                        @Override
                        public void done(User o, BmobException e) {
                            if (e==null) {

                                Toast.makeText(Register.this, "注册成功", Toast.LENGTH_SHORT).show();

                            }else {

                                Toast.makeText(Register.this, "注册失败", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
