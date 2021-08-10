package com.example.nowsafe;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.lakue.pagingbutton.LakuePagingButton;
import com.lakue.pagingbutton.OnPageSelectListener;

public class SearchActivity extends Activity {

    LakuePagingButton lpb_buttonlist;
    int page = 1;
    int max_page = 30;
    static final String[] LIST_MENU = { "2021년 7월 30일 장비점검표","2021년 7월 29일 장비점검표","2021년 7월 28일 장비점검표","2021년 7월 27일 장비점검표",
            "2021년 7월 26일 장비점검표","2021년 7월 25일 장비점검표","2021년 7월 24일 시설점검표","2021년 7월 23일 장비점검표","2021년 7월 22일 장비점검표","2021년 7월 21일 장비점검표","2021년 7월 20일 장비점검표"} ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, LIST_MENU);

        ListView listview = (ListView) findViewById(R.id.list);//뷰 영역
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // 코드 계속 ...

            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                // get TextView's Text.
                String strText = (String) parent.getItemAtPosition(position);

                // TODO : use strText
            }
        });

        lpb_buttonlist = findViewById(R.id.lpb_buttonlist);

        //한 번에 표시되는 버튼 수 (기본값 : 5)
        lpb_buttonlist.setPageItemCount(4);

        //총 페이지 버튼 수와 현재 페이지 설정
        lpb_buttonlist.addBottomPageButton(max_page,1);

        //페이지 리스너를 클릭했을 때의 이벤트
        lpb_buttonlist.setOnPageSelectListener(new OnPageSelectListener() {
            //PrevButton Click
            @Override
            public void onPageBefore(int now_page) {
                //prev 버튼을 클릭하면 버튼이 재설정되고 버튼이 그려집니다.
                lpb_buttonlist.addBottomPageButton(max_page,now_page);
                Toast.makeText(SearchActivity.this, ""+now_page, Toast.LENGTH_SHORT).show();


                //해당 페이지에 대한 소스 코드 작성
                //...
            }

            @Override
            public void onPageCenter(int now_page) {
                Toast.makeText(SearchActivity.this, ""+now_page, Toast.LENGTH_SHORT).show();
                //Write source code for there page
                //...
            }

            //NextButton Click
            @Override
            public void onPageNext(int now_page) {
                //next 버튼을 클릭하면 버튼이 재설정되고 버튼이 그려집니다.
                lpb_buttonlist.addBottomPageButton(max_page,now_page);
                Toast.makeText(SearchActivity.this, ""+now_page, Toast.LENGTH_SHORT).show();
                //해당 페이지에 대한 소스 코드 작성
                //...
            }
        });



// Spinner
        Spinner yearSpinner = (Spinner) findViewById(R.id.spinner_year);
        ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(this,
                R.array.date_year, android.R.layout.simple_spinner_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);

        Spinner monthSpinner = (Spinner) findViewById(R.id.spinner_month);
        ArrayAdapter monthAdapter = ArrayAdapter.createFromResource(this,
                R.array.date_month, android.R.layout.simple_spinner_item);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(monthAdapter);

        Spinner selectSpinner = (Spinner) findViewById(R.id.spinner_select);
        ArrayAdapter selectAdapter = ArrayAdapter.createFromResource(this,
                R.array.select, android.R.layout.simple_spinner_item);
        selectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectSpinner.setAdapter(selectAdapter);

    }
}

