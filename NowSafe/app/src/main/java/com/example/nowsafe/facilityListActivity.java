package com.example.nowsafe;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class facilityListActivity extends AppCompatActivity {

    ListView listview;
    ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facilitylist);

        // 빈 데이터 리스트 생성.
        items = new ArrayList<String>();
        items.add("2층 소화기-1");
        items.add("2층 소화기-2");
        items.add("2층 소화기-3");

        // ArrayAdapter 생성. 아이템 View를 선택(single choice)가능하도록 만듦.
        final ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_single_choice, items);

        // listview 생성 및 adapter 지정.
        listview = findViewById(R.id.listview);
        listview.setAdapter(adapter);

        //add bytton에 대한 이벤트 처리
        Button btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder getname = new AlertDialog.Builder(facilityListActivity.this);
                getname.setMessage("시설물의 이름을 입력해주세요. ");
                getname.setTitle("시설물 추가");
                final EditText ans = new EditText(facilityListActivity.this);
                getname.setView(ans);
                getname.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = ans.getText().toString();
                        // 아이템 추가.
                        items.add(name);
                        // listview 갱신
                        adapter.notifyDataSetChanged();
                        //사라지기
                        dialog.dismiss();
                    }
                });
                getname.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                getname.show();
            }
        });


        // delete button에 대한 이벤트 처리.
        Button btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int count, checked;
                count = adapter.getCount();

                if (count > 0) {
                    // 현재 선택된 아이템의 position 획득.
                    checked = listview.getCheckedItemPosition();

                    if (checked > -1 && checked < count) {
                        // 아이템 삭제
                        items.remove(checked);

                        // listview 선택 초기화.
                        listview.clearChoices();

                        // listview 갱신.
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });

        //시작 버튼에 대한 이벤트 처리
        Button btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent( getApplicationContext(), com.example.nowsafe.ChecklistActivity.class);
                startActivity(intent1);
            }
        });
    }
}
