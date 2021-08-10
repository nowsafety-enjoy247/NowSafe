package com.example.nowsafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class ManagerMenuActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    //매니저 메뉴 보이게
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.managermenupractice);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 왼쪽 상단 버

        // 튼 만들기
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.resizemenubar); //왼쪽 상단 버튼 아이콘 지정
        //getSupportActionBar().setLogo(R.drawable.logo_white2);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.navigation_view);

        Button BtnNum1 = (Button) findViewById(R.id.BtnNum1);
        BtnNum1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),  com.example.nowsafe.FakeActivity.class);
                startActivity(intent);
            }
        });


        Button qrCodeButton = (Button) findViewById(R.id.qrCodeButton);//qr코드로 가는 버튼
        qrCodeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),  com.example.nowsafe.QRcoder.class);
                startActivity(intent1);
            }
        });

        Button checklist = (Button) findViewById(R.id.checklist);//시설점검으로 가는 버튼
        checklist.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),  com.example.nowsafe.facilityListActivity.class);
                startActivity(intent1);
            }
        });

        Button gotolist = (Button) findViewById(R.id.gotolist);//점검관리로 가는 버튼
        gotolist.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),  com.example.nowsafe.SearchActivity.class);
                startActivity(intent1);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ // 왼쪽 상단 버튼 눌렀을 때
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() { //뒤로가기 했을 때
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
