package com.example.l.mediumproject;

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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name,password,password2;
    Button register;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String name2,password3,password4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name= (EditText) findViewById(R.id.nameId);
        password= (EditText) findViewById(R.id.passwordId);
        password2= (EditText) findViewById(R.id.password2Id);
        register = (Button) findViewById(R.id.register2Id);
        sharedPreferences=getSharedPreferences("user",MODE_PRIVATE);
        editor= sharedPreferences.edit();
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        name2=name.getText().toString();
        password3=password.getText().toString();
        password4=password2.getText().toString();
        if (!TextUtils.isEmpty(name2)&& !TextUtils.isEmpty(password3)&&!TextUtils.isEmpty(password4)&&password3.equals(password4)) {
            //使用edit的put方法存值
            editor.putString("name", name2);
            editor.putString("password", password3);
            //将操作提交
            editor.commit();
            Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(), "注册失败，请重新填写", Toast.LENGTH_LONG).show();
        }

    }
}
