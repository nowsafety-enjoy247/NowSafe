package com.example.nowsafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ManagerMenuActivity extends AppCompatActivity {

    //매니저 메뉴 보이게
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.managermenu);

        Button gotomyinfo = (Button) findViewById(R.id.gotomyinfo);
        gotomyinfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),  com.example.nowsafe.MyInfomationActivity.class);
                startActivity(intent);
            }
        });
    }

}
