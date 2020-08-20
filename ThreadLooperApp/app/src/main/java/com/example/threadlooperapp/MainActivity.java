package com.example.threadlooperapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ed;
    Button btn;
    TextView tv;
    Handler handler = new Handler();
    ProcessThread thread = new ProcessThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = findViewById(R.id.edit1);
        btn = findViewById(R.id.button);
        tv = findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = ed.getText().toString();
                Message msg = Message.obtain(); //메세지 객체생성
                msg.obj = str;

                thread.processHandler.sendMessage(msg);
            }
        });
    }

    class ProcessThread extends Thread{ //메시지 유무 검사
        ProcessHandler processHandler = new ProcessHandler();
        @Override
        public void run() {
            Looper.prepare();
            Looper.loop();
        }

        class ProcessHandler extends Handler{
            @Override
            public void handleMessage(@NonNull Message msg) {
                final String output = msg.obj+" from Mainthread";
                Log.i("Looper Test : ", output);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(output);
                    }
                });
            }
        }
    }
}