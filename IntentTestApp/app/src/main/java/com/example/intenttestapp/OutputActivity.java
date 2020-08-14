package com.example.intenttestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OutputActivity extends AppCompatActivity {

    TextView tv;
    Button btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        Intent intent = getIntent();
        Member member = (Member)intent.getSerializableExtra("member");
        /*String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age", 0);
        String[] hobby = intent.getStringArrayExtra("hobby");*/
        tv = findViewById(R.id.tvResult);
        btnFinish = findViewById(R.id.btnFinish);
        String str = "이름 : " + member.getName();
        str += "\n나이 : "+ member.getAge() + "\n취미 : ";
        String[] hobby = member.getHobby();
        for(int i=0; i<hobby.length; i++){
            str += hobby[i] + "";
        }
        tv.setText(str);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}