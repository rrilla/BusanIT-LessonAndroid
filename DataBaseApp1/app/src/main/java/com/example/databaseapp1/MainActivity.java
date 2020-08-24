package com.example.databaseapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.sql.DriverManager.println;

public class MainActivity extends AppCompatActivity {

    EditText edDB, edTable;
    Button btnDB, btnTable, btnInsert, btnSelect, btnDelete, btnUpdate;
    TextView tv;
    SQLiteDatabase database;
    String tableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edDB = findViewById(R.id.editDB);
        edTable = findViewById(R.id.editTable);
        tv = findViewById(R.id.tvResult);
        btnDB = findViewById(R.id.btnDB);
        btnTable = findViewById(R.id.btnTable);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSearch);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);

        btnDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dbName = edDB.getText().toString();
                createDatabase(dbName);
            }
        });
        btnTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableName = edTable.getText().toString();
                createTable();
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
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteData();
            }
        });
    }

    private void deleteData() {
        println("deleteData() 호출");
        String sql = "delete from " + tableName +"where ";

    }

    private void selectData() {
        println("selectData() 호출");
        String sql = "select * from " + tableName ;
        Cursor cursor = database.rawQuery(sql, null);   //where 할시 값 입력
        int count = cursor.getCount();
        for(int i=0; i<count; i++){
            cursor.moveToNext();
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            int age = cursor.getInt(2);
            String mobile = cursor.getString(3);
            println("레코드# : "+i+":"+id+","+name+","+age+","+mobile);
        }
        cursor.close();
    }

    private void insertData() {
        println("insertData() 호출");
        if(database == null) {
            println("db를 먼저 생성하셈.");
            return;
        }
        if(tableName == null){
            println("table을 먼저 생성하셈.");
            return;
        }
        String sql = "insert into " + tableName +"(name,age,mobile) " +
                "values('Han','27', '010-6422-2642')";
        database.execSQL(sql);
        println("insert성공");
    }

    private void createTable() {
        println("createTable() 호출");
        if(database==null){
            println("db를 먼저 생성하세요");
            return;
        }
        String sql = "create table if not exists " + tableName + "("
                + "_id integer primary key autoincrement,"
                + "name text,"
                + "age integer,"
                + "mobile text)";
        database.execSQL(sql);
        println("테이블 생성함 : " + tableName);
    }

    private void createDatabase(String dbName) {
        println("createDatabase() 호출");
        database = openOrCreateDatabase(dbName, MODE_PRIVATE, null);    //있으면 오픈,없으면 생성
        println("'" + dbName + "' db 생성됨");
    }

    private void println(String data){
        tv.append(data + "\n");
    }
}