package com.example.nowsafe;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QRcoder extends AppCompatActivity {
    ImageView ivOutput;
    TextView phone;
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
    }
}