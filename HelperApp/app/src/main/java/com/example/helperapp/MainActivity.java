package com.example.helperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edName,edAge,edMobile;
    TextView tvResult;
    Button btnDB,btnInsert,btnSelect, btnUpdate,btnDelete;

    DatabaseHelper helper;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult=findViewById(R.id.tvResult);
        btnDB=findViewById(R.id.btnDB);
        edName = findViewById(R.id.editName);
        edAge = findViewById(R.id.editAge);
        edMobile = findViewById(R.id.editMobile);
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
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectData();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteData();
            }
        });
    }

    private void insertData() {
        println("insertData() 호출함");
        String name = edName.getText().toString();
        int age = Integer.parseInt(edAge.getText().toString());
        String mobile = edMobile.getText().toString();
        String sql = "insert into emp(name, age, mobile) values('"+name+"','"+age+"','"+mobile+"')";
        database.execSQL(sql);
    }

    private void selectData(){
        println("selectData() 호출함");
        String sql = "select * from emp";
        Cursor cursor = database.rawQuery(sql,null);
        int count = cursor.getCount();
        println("레코드 수 : " + count );
        for(int i=0; i<count; i++){
            cursor.moveToNext();
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            int age = cursor.getInt(2);
            String mobile = cursor.getString(3);
            println("레코드 #" + i + " : " + id + ", " + name + ", " + age + ", " + mobile);
        }
        cursor.close();
    }

    private void updateData(){
        String name = edName.getText().toString();
        String mobile = edMobile.getText().toString();
        String sql = "update emp set mobile='"+mobile+"' where name='"+name+"'";
    }

    private void deleteData(){
        String name = edName.getText().toString();
        String sql = "delete from emp where name='"+name+"'";
        database.execSQL(sql);
    }

    private void createDatabase(){
        println("createDatabase() 호출함");
        helper = new DatabaseHelper(this);
        database = helper.getWritableDatabase();
        println("db 생성");
    }

    private void println(String data){
        tvResult.append(data+"\n");
    }
}