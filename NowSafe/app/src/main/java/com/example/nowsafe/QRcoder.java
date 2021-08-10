package com.example.nowsafe;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QRcoder extends AppCompatActivity {
    ImageView ivOutput;
    TextView phone;
    int minute;
    long min;
    TextView tv_timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrcoder);

        //액션바 이미지넣기
        String sText = "01031005136";//암호화할 문자

        //textview
        phone=findViewById(R.id.phone);
        phone.setText(sText);
        //qr 생성코드
        ivOutput=findViewById(R.id.ivoutput);

        MultiFormatWriter writer =new MultiFormatWriter();

        try {
            //크기조정
            BitMatrix matrix = writer.encode(sText, BarcodeFormat.QR_CODE,800, 800);
            BarcodeEncoder encoder =new BarcodeEncoder();
            Bitmap bitmap = encoder.createBitmap(matrix);
            ivOutput.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        //타이머 생성
        tv_timer=findViewById(R.id.timer);
        minute=Integer.parseInt("15");
        min= minute*1000;
        counter(min);
    }
    private void counter(long min) {
        CountDownTimer timer = new CountDownTimer(min, 1000) {
            public void onTick(long millisUntilFinished) {//시작
                int seconds = (int) (millisUntilFinished / 1000) % 60;
                tv_timer.setText(String.format("남은 시간: %d초",seconds));
                tv_timer.setText(Html.fromHtml("<font color=\"#000000\">"+"남은 시간: "+"</font>"
                        +"<font color=\"#e90000\">"+seconds+"</font>"+"<font color=\"#000000\">"+"초"+"</font>"));
            }
            public void onFinish() {//끝

                //이 코드 쓰니까 무한 새로고침 되는거 막고 싶습니다..........
                /*try {
                    //TODO 액티비티 화면 재갱신 시키는 코드
                    Intent intent = getIntent();
                    //finish(); //현재 액티비티 종료 실시
                    //overridePendingTransition(0, 0); //인텐트 애니메이션 없애기
                    //startActivity(intent); //현재 액티비티 재실행 실시
                    //overridePendingTransition(0, 0); //인텐트 애니메이션 없애기
                }
                catch (Exception e){
                    e.printStackTrace();
                }*/

            }
        };
        timer.start();
    }
}