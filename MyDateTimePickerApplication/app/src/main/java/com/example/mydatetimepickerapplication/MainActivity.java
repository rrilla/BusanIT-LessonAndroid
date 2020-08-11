package com.example.mydatetimepickerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono;
    RadioGroup rg;
    RadioButton rdoDate, rdoTime;
    DatePicker dPicker;
    TimePicker tPicker;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        // 크로노미터
        chrono = findViewById(R.id.chronometer1);

        // 라디오그룹과 라디오버튼 2개
        rg=findViewById(R.id.radioGroup1);
        rdoDate = findViewById(R.id.rdoCal);
        rdoTime =  findViewById(R.id.rdoTime);

        // FrameLayout의 2개 위젯
        tPicker = findViewById(R.id.timePicker1);
        dPicker = findViewById(R.id.datePicker1);

        // 텍스트뷰
        tvResult = findViewById(R.id.tvResult);

        // 처음에는 2개를 안보이게 설정
        rg.setVisibility(View.INVISIBLE);
        tPicker.setVisibility(View.INVISIBLE);
        dPicker.setVisibility(View.INVISIBLE);

        rdoDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tPicker.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.VISIBLE);
            }
        });
        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tPicker.setVisibility(View.VISIBLE);
                dPicker.setVisibility(View.INVISIBLE);
            }
        });
        chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
                rg.setVisibility(View.VISIBLE);

            }
        });
        dPicker.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);
                String str=dPicker.getYear()+"년 ";
                str+=(dPicker.getMonth()+1)+"월 ";
                str+=dPicker.getDayOfMonth()+"일 ";
                str+=tPicker.getCurrentHour()+"시 ";
                str+=tPicker.getCurrentMinute()+"분 예약됨";
                tvResult.setText(str);
                rg.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.INVISIBLE);

                return true;
            }
        });
    }
}