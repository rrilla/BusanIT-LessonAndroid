package com.example.threadapp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button btn;
    ProgressBar progressBar;
    //MainHandler handler;
    int value=0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.edit1);
        btn = findViewById(R.id.btn1);
        progressBar = findViewById(R.id.progressBar);
        //handler=new MainHandler();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackgroundThread thread=new BackgroundThread();
                thread.start();
            }
        });
    }

    class BackgroundThread extends Thread{
        @Override
        public void run() {
            for(int i=0; i<100;i++){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){}

                value += 1;
                Log.i("Thread1: ","vaule:"+value);


                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        et.setText("value : "+value);
                    }
                });
                /*Message msg=handler.obtainMessage();
                Bundle bundle=new Bundle();
                bundle.putInt("value",value);
                msg.setData(bundle);
                handler.sendMessage(msg);
                //et.setText("value:"+value);*/
            }
        }
    }

    /*class MainHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Bundle bundle=msg.getData();
            int value=bundle.getInt("value");
            et.setText("value:"+value);

        }
    }*/



}