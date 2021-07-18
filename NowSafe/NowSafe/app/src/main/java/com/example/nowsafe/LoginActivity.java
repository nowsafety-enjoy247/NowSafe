package com.example.nowsafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        Button registerButton = (Button) findViewById(R.id.gotoRegister);
        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),  com.example.nowsafe.RegisterActivity.class);
                startActivity(intent);
            }
        });

        Button findpasswordbtn = (Button) findViewById(R.id.gotoPassword);
        findpasswordbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),  com.example.nowsafe.FindPasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    public void goToMain(View view) {
        Intent intent = new Intent(getApplicationContext(), SelectUserActivity.class);
        startActivity(intent);
    }
}
