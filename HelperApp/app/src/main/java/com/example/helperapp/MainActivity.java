package com.example.helperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edDB,edTable;
    TextView tvResult;
    Button btnDB,btnTable,btnInsert,btnSelect, btnUpdate,btnDelete;

    DatabaseHelper helper;
    SQLiteDatabase database;
    String tableName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edDB=findViewById(R.id.editDB);
        edTable=findViewById(R.id.editTable);
        tvResult=findViewById(R.id.tvResult);
        btnDB=findViewById(R.id.btnDB);
        btnTable=findViewById(R.id.btnTable);
        btnInsert=findViewById(R.id.btnInsert);
        btnSelect=findViewById(R.id.btnselect);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnDelete=findViewById(R.id.btnDelete);
        btnDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDatabase();
            }
        });
    }
    private void createDatabase(String name){
        println("createDatebase() 호출함");
        helper=new DatabaseHelper(this);
    }

    private void println(String data){
        tvResult.append(data+"\n");
    }
}