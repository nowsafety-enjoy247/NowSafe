package com.example.nowsafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyInfomationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinfomation);

        Button registerButton = (Button) findViewById(R.id.gotochangepassword);
        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),  com.example.nowsafe.ChangePasswordActivity.class);
                startActivity(intent);
            }
        });

        Button gotologin = (Button) findViewById(R.id.gotologin);
        gotologin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),  com.example.nowsafe.LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}