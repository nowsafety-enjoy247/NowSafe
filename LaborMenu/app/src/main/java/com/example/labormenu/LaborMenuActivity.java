package com.example.labormenu;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LaborMenuActivity extends AppCompatActivity {

    //노동자 메뉴 보이게
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.labormenu);
    }
}
