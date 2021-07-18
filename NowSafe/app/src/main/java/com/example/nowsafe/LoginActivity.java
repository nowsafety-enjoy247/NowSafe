package com.example.nowsafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //기본화면 구성
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //회원가입 버튼 눌렀을때
        Button button = (Button) findViewById(R.id.registerButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        //로그인 버튼 눌렀을때

        //비밀번호 찾기 버튼 눌렀을때
    }

    public void goToMain(View view) {
        Intent intent = new Intent(getApplicationContext(), SelectUserActivity.class);
        startActivity(intent);
    }
}
