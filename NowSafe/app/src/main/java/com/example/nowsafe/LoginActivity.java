package com.example.nowsafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private EditText et_id, et_pass;
    private Button btn_login, btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //기본화면 구성
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //회원가입 버튼 눌렀을때
        btn_register = (Button) findViewById(R.id.registerButton);
        btn_register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });


        //아이디랑 비밀번호랑 버튼 가져오기
        et_id=findViewById(R.id.idInput_text);
        et_pass=findViewById(R.id.passwordInput_text);
        btn_login = findViewById(R.id.changepassworddone);
        //로그인 버튼 눌렀을때
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // EditText에 현재 입력되어있는 값을 get(가져온다)해온다.
                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            // TODO : 인코딩 문제때문에 한글 DB인 경우 로그인 불가
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) { // 로그인에 성공한 경우
                                //아이디랑 비밀번호 가져오기
                                String userID = jsonObject.getString("userID");
                                String userPass = jsonObject.getString("userPassword");
                                Toast.makeText(getApplicationContext(),"로그인에 성공하였습니다.",Toast.LENGTH_SHORT).show();
                                //화면 전환
                                Intent intent = new Intent(LoginActivity.this, SelectUserActivity.class);
                                intent.putExtra("userID", userID);
                                intent.putExtra("userPass", userPass);
                                startActivity(intent);
                                //1)관리자인 경우
                                /*Intent intent1 = new Intent(LoginActivity.this, ManagerMenuActivity.class);
                                intent1.putExtra("userID", userID);
                                intent1.putExtra("userPass", userPass);
                                startActivity(intent1);
                                //2)노동자인 경우
                                Intent intent2 = new Intent(LoginActivity.this, ManagerMenuActivity.class);
                                intent2.putExtra("userID", userID);
                                intent2.putExtra("userPass", userPass);
                                startActivity(intent2);*/
                            } else { // 로그인에 실패한 경우
                                Toast.makeText(getApplicationContext(),"존재하지 않는 회원입니다.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(userID, userPass, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });


        //비밀번호 찾기 버튼 눌렀을때
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
