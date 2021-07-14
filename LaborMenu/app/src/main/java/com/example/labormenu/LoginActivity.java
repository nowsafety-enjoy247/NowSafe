package com.example.labormenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button button = (Button) findViewById(R.id.newActivity);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void goToMain(View view) {
<<<<<<< HEAD
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
=======
        Intent intent = new Intent(getApplicationContext(), SelectUserActivity.class);
>>>>>>> Hyunjin
        startActivity(intent);
    }
}
