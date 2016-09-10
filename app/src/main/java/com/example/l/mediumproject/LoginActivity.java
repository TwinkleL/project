package com.example.l.mediumproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name,password;
    Button register,login;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String name2,password2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = (EditText) findViewById(R.id.nameloginId);
        password= (EditText) findViewById(R.id.passwordloginId);
        register = (Button) findViewById(R.id.registerId);
        login= (Button) findViewById(R.id.loginId);
        register.setOnClickListener(this);
        login.setOnClickListener(this);
        sharedPreferences=getSharedPreferences("user",MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registerId:
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.loginId:
                name2= name.getText().toString();
                password2=password.getText().toString();
                if (!TextUtils.isEmpty(name2)&&!TextUtils.isEmpty(password2)) {
                    if (name2.equals(sharedPreferences.getString("name", "zsp"))&&
                            password2.equals(sharedPreferences.getString("password", "123"))) {
                        Toast.makeText(getApplicationContext(), "登陆成功", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(), "用户名密码错误", Toast.LENGTH_LONG).show();

                    }

                }else {
                    Toast.makeText(getApplicationContext(), "用户名密码不能为空", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
