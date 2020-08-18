package com.example.cardviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    //GridLayoutManager layoutManager;
    PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.recyclerView1);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PersonAdapter();
        adapter.addItem(new Person("한재현", "010-6422-2642"));
        adapter.addItem(new Person("한수진", "010-2352-2642"));
        adapter.addItem(new Person("한석희", "010-6343-2642"));
        adapter.addItem(new Person("채옥자", "010-3532-2642"));
        adapter.addItem(new Person("한규만", "010-7989-2642"));
        adapter.addItem(new Person("한라봉", "010-0989-2642"));
        adapter.addItem(new Person("한라봉", "010-0989-2642"));
        adapter.addItem(new Person("한라봉", "010-0989-2642"));
        adapter.addItem(new Person("한라봉", "010-0989-2642"));
        recyclerView.setAdapter(adapter);


    }
}