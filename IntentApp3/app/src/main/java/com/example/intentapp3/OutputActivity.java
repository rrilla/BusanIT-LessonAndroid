package com.example.intentapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OutputActivity extends AppCompatActivity {

    TextView tvId, tvPw, tvName, tvPhone;
    Button btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        Intent intent = getIntent();
        Member member = (Member)intent.getSerializableExtra("member");

        tvId = findViewById(R.id.tvId);
        tvPw = findViewById(R.id.tvPw);
        tvName = findViewById(R.id.tvName);
        tvPhone = findViewById(R.id.tvPhone);
        btnFinish = findViewById(R.id.btnFinish);

        tvId.setText("아이디 : " + member.getId());
        tvPw.setText("비번 : " + member.getPw());
        tvName.setText("이름 : " + member.getName());
        tvPhone.setText("폰 : " + member.getPhone());
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}