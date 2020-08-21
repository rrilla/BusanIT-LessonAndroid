package com.example.socketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.ServerSocket;

public class MainActivity extends AppCompatActivity {

    Button btnSend, btnServer;
    EditText editText;
    TextView tvClient, tvServer;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        editText = findViewById(R.id.edit1);
        tvClient = findViewById(R.id.tvClient);
        tvServer = findViewById(R.id.tvServer);
        btnSend = findViewById(R.id.btnSend);
        btnServer = findViewById(R.id.btnServer);

        btnServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        startServer();
                    }
                });
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void startServer() {
        try {
            int portNum = 5001;
            ServerSocket serverSocket = new ServerSocket(portNum);
            printServerLog("서버시작함 : " + portNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printServerLog(final String data) {
        Log.d("MainActivity", data);
        handler.post(new Runnable() {
            @Override
            public void run() {
                tvServer.append(data + "\n");
            }
        });
    }
}