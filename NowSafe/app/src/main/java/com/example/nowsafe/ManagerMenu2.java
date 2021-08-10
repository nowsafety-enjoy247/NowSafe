package com.example.nowsafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ManagerMenu2 extends AppCompatActivity{//fragement? 이거 해결해야 인텐트 됨

    TextView text1;
    TextView text2;
    TextView text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.managerinfomation);

        text1 = (TextView) findViewById(R.id.nav_changepassword);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),  com.example.nowsafe.ChangePasswordActivity.class);
                startActivity(intent);
            }
        });

        text2 = (TextView) findViewById(R.id.nav_info);
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),  com.example.nowsafe.MyInfomationActivity.class);
                startActivity(intent);
            }
        });

        text3 = (TextView) findViewById(R.id.nav_logout);

        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),  com.example.nowsafe.LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}