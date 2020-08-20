package com.example.asynctaskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    Button btnStart, btnStop;
    int value;
    BackgroundTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressBar2);
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

    class BackgroundTask extends AsyncTask<Integer,Integer, Integer> {

        @Override
        protected void onPreExecute() {
            value=0;
            progressBar.setProgress(value);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            while(isCancelled()==false){
                value++;
                if(value>=100){
                    break;
                }else{
                    publishProgress(value);
                }
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){}
            }
            return value;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0].intValue());
        }

        @Override
        protected void onPostExecute(Integer integer) {
            progressBar.setProgress(0);
        }

        @Override
        protected void onCancelled() {
            progressBar.setProgress(0);
        }
    }
}