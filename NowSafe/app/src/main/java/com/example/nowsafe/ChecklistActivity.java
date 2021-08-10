package com.example.nowsafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChecklistActivity extends AppCompatActivity {

    ListView listView1;
    ArrayAdapter<String> adapter;
    ArrayList<String> listItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist);
        setTitle("ListView 연습");

        listItem = new ArrayList<String>();
        listItem.add("소화기 호스가 청결합니까?");
        listItem.add("그늘에 보관되어 있습니까?");
        listItem.add("소화기와 받침대가 깨끗합니까?");
        listItem.add("안전핀이 고정되어 있습니까?");
        listItem.add("습기가 적은 곳에 보관되어 있습니까?");
        listItem.add("손잡이가 안찌그러져 있습니까?");

        adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_multiple_choice,listItem);
        listView1 = findViewById(R.id.listView1);
        listView1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // 콜백매개변수는 순서대로 어댑터뷰, 해당 아이템의 뷰, 클릭한 순번, 항목의 아이디
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(),listItem.get(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });

        Button end_check = (Button) findViewById(R.id.end_check);
        end_check.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent( getApplicationContext(), com.example.nowsafe.ManagerMenuActivity.class);
                startActivity(intent1);
            }
        });
    }
}
