package com.example.nowsafe;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ManagerMenuActivity extends AppCompatActivity {

    //매니저 메뉴 보이게
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.managermenu);
    }
}
