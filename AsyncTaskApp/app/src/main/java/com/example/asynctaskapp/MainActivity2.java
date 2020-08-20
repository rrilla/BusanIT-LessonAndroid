package com.example.asynctaskapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tv;
    Button btnStart, btnStop;
    int value;
    BackgroundTask task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        btnStart=findViewById(R.id.btnStart);
        btnStop=findViewById(R.id.btnStop);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task=new BackgroundTask();
                task.execute();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task.cancel(true);
            }
        });
    }

    class BackgroundTask extends AsyncTask<Integer,Integer,Integer>{

        @Override
        protected void onPreExecute() {
            value=0;
            tv.setText("value:"+value);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            while (isCancelled()==false){
                if(value>=100){
                    break;
                }else{
                    value++;
                    publishProgress(value);
                }
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){}
            }
            return value;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            tv.setText("value:"+values[0]);
        }

        @Override
        protected void onPostExecute(Integer integer) {

            tv.setText("value:"+integer);
        }

        @Override
        protected void onCancelled() {
            tv.setText("value:"+0);
        }
    }

}