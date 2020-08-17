package com.example.listviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    ListView lv;
    String[] text = {"히어로즈", "24시", "로스트", "로스트룸", "스몰빌", "탐정몽크", "빅뱅이론",
    "프렌즈", "덱스트", "가쉽걸", "테이큰", "슈퍼네추럴", "프리즌브레이크", "반지의 제왕"};
    ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        lv = findViewById(R.id.listView1);
        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_single_choice, text);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                tv.setText(text[position]);
            }
        });
    }
}