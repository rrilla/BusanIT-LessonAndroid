package com.example.ex1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    RadioGroup rg;
    Button btnEnd;
    RadioButton rbCal, rbTime;
    DatePicker datePicker;
    TimePicker timePicker;
    TextView tvResult;
    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");
        btnEnd = findViewById(R.id.btnEnd);
        chronometer = findViewById(R.id.chronometer);
        rbCal = findViewById(R.id.rbCal);
        rbTime = findViewById(R.id.rbTime);
        timePicker = findViewById(R.id.timePick1);
        datePicker = findViewById(R.id.datePick1);
        rg = findViewById(R.id.rg);
        tvResult = findViewById(R.id.tvResult);
        timePicker.setVisibility(View.INVISIBLE);
        datePicker.setVisibility(View.INVISIBLE);
        rbTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.VISIBLE);
            }
        });

        rbCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.VISIBLE);
            }
        });

        chronometer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
                rg.setVisibility(View.VISIBLE);
            }
        });

       

        btnEnd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);
                String str = selectYear + "년 ";
                str += selectMonth + "월 ";
                str += selectDay + "일 ";
                str += timePicker.getCurrentHour() + "시 ";
                str += timePicker.getCurrentMinute() + "분 예약됨";
                tvResult.setText(str);
            }
        });

        /*calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                selectYear = year;
                selectMonth = month+1;
                selectDay = day;
            }
        });*/
    }
}