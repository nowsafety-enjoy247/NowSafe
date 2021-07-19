package com.example.nowsafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LaborMenuActivity extends AppCompatActivity {

    //노동자 메뉴 보이게
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.labormenu);

        Button myInformationButton = (Button) findViewById(R.id.myInformationButton);
        myInformationButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.example.nowsafe.MyInfomationActivity.class);
                startActivity(intent);
            }
        });
    }
}
