package com.example.intentapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    Button btnClose;
    EditText edId, edPw, edName, edPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        edId = findViewById(R.id.edId);
        edName = findViewById(R.id.edName);
        edPw = findViewById(R.id.edPw);
        edPhone = findViewById(R.id.edPhone);
        btnClose = findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edId.getText().toString();
                String pw = edPw.getText().toString();
                String name = edName.getText().toString();
                String phone = edPhone.getText().toString();
                Member member = new Member(id, pw, name, phone);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("member", member);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}