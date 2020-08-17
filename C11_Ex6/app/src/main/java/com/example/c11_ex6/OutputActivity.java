package com.example.c11_ex6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class OutputActivity extends AppCompatActivity {

    Button btnBack;
    TextView textName, textActor, textContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        btnBack = findViewById(R.id.button);
        textName = findViewById(R.id.textName);
        textActor = findViewById(R.id.textActor);
        textContent = findViewById(R.id.textContent);

    }
}