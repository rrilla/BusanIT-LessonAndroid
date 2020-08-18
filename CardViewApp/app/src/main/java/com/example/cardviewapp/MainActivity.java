package com.example.cardviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;
    Layout1 layout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout1 = findViewById(R.id.layout1);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        layout1.setImage(R.drawable.profile1);
        layout1.setName("한재현");
        layout1.setMobile("010-6422-2642");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout1.setImage(R.drawable.profile1);
                layout1.setName("한재현");
                layout1.setMobile("010-6422-2642");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout1.setImage(R.drawable.profile2);
                layout1.setName("한수진");
                layout1.setMobile("010-4994-2642");
            }
        });
    }
}