package com.example.nowsafe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

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
        setContentView(R.layout.activity_qrcoder);

        String sText = "01050004942";//암호화할 문자
        //textview
        phone=findViewById(R.id.phone);
        phone.setText(sText);

        //qr 생성코드

        ivOutput=findViewById(R.id.ivoutput);//xml ㅇㅣㄴ자

        MultiFormatWriter writer =new MultiFormatWriter();

        try {
            //크기조정
            BitMatrix matrix = writer.encode(sText, BarcodeFormat.QR_CODE,200, 200);
            BarcodeEncoder encoder =new BarcodeEncoder();

            Bitmap bitmap = encoder.createBitmap(matrix);

            ivOutput.setImageBitmap(bitmap);


        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}