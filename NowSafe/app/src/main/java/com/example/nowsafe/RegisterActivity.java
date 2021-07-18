package com.example.nowsafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_id, et_pass, et_pass2,et_name;
    private RadioGroup rb_position;
    private Button btn_register;

    //기본 화면 구성
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        //아이디 값으로 컴포넌트 찾아오기
        et_id = findViewById(R.id.UserTextPhone);
        et_pass = findViewById(R.id.editTextTextPassword);
        et_pass2 = findViewById(R.id.editTextTextPassword2);
        et_name = findViewById(R.id.InputUserName);
        rb_position = findViewById(R.id.radioGroup);

        //회원가입 버튼 눌렀을때 수행
        btn_register = findViewById(R.id.registerButton);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // EditText에 현재 입력되어있는 값을 get(가져온다)해온다.
                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();
                String userPass2 = et_pass2.getText().toString();
                String userName = et_name.getText().toString();
                //라이도 그룹에서 선택된 라이도 버튼 텍스트 가져오기
                int selectedId = rb_position.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                String userPosition = (String) radioButton.getText().toString();

                //위에 항목 중 안 쓴 항목이 있는 경우
                if (userName.length() == 0 || userID.length() == 0 || userPosition.length() == 0 ||
                        userPass.length() == 0 || userPass2.length() == 0) {
                    Toast.makeText(getApplicationContext(), "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                //비밀번호 확인과 비밀번호가 다른 경우
                else if (!userPass.equals(userPass2)) {
                    Toast.makeText(getApplicationContext(), "비밀번호 확인이 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
                //assignment!!!! 아이디 중복확인도 추가!

                //그 외의 경우
                else {
                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                boolean success = jsonObject.getBoolean("success");
                                if (success) { // 회원등록에 성공한 경우
                                    Toast.makeText(getApplicationContext(), "회원 등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                } else { // 회원등록에 실패한 경우
                                    Toast.makeText(getApplicationContext(), "회원 등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    };
                    // 서버로 Volley를 이용해서 요청을 함.
                    RegisterRequest registerRequest = new RegisterRequest(userID, userPass, userName, userPosition, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                    queue.add(registerRequest);
                }
            }
        });
    }
}