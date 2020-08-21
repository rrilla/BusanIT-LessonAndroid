package com.example.httpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText ed;
    TextView tv;
    Button btn;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        ed = findViewById(R.id.edit1);
        tv = findViewById(R.id.textView);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String strUrl = ed.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        request(strUrl);
                    }
                }).start();
            }
        });
    }

    private void request(String strUrl) {
        StringBuilder output = new StringBuilder();
        try{
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if(conn != null){   //정상적으로 연결됬으면
                conn.setConnectTimeout(10000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                int resCode = conn.getResponseCode();
                BufferedReader reader = new BufferedReader( //BufferedReader 라인 단위로 읽을 수 있음
                        new InputStreamReader(conn.getInputStream()));
                            //InputStreamReader은 바이트단위, 한글자씩 읽음
                String line = null;
                while(true){
                    line = reader.readLine();   //Buffer은 라인 단위로 읽을 수 있음
                    if(line == null){
                        break;
                    }
                    output.append(line + "\n");
                }
                reader.close();
                conn.disconnect();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}