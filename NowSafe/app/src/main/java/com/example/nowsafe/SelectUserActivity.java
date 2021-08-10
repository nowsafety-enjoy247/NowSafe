package com.example.nowsafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SelectUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectmode);



        Button manager = (Button) findViewById(R.id.managerButton);
        manager.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), com.example.nowsafe.ManagerMenuActivity.class);
                startActivity(intent);
            }
        });

        Button labor = (Button) findViewById(R.id.laborButton);
        labor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), com.example.nowsafe.LaborMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}