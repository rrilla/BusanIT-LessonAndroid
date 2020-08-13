package com.example.activitytestapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    Button btnSecond,btnMyActivity;
    EditText edName,edAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnSecond=findViewById(R.id.btnSecond);
        btnMyActivity=findViewById(R.id.btnMyActivity);
        edName=findViewById(R.id.editName);
        edAge=findViewById(R.id.editAge);
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("name",edName.getText().toString());
                intent.putExtra("age",edAge.getText().toString());
                startActivity(intent);
            }
        });
    }
}