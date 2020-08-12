package com.example.ex5_filesave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    CalendarView calendarView;
    EditText ed;
    Button button;
    int selectYear, selectMonth, selectDay;
    String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = findViewById(R.id.calendarView1);
        ed = findViewById(R.id.editDiary);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream os = null;
                try{
                    os = openFileOutput(filename, Context.MODE_PRIVATE);
                    os.write((ed.getText().toString().getBytes());
                    os.close();
                    ed.setText("");
                    Toast.makeText(MainActivity.this, "저장되었슴", Toast.LENGTH_SHORT).show());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day){

                selectYear = year;
                selectMonth = month+1;
                try {
                    selectDay = day;
                    selectMonth = month;

                } catch (Exception e) {
                    e.printStackTrace();
                }
            };

        });

    }
}