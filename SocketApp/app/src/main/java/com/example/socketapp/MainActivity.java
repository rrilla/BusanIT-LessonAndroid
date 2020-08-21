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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

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
                }).start();
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String data = editText.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        send(data);
                    }
                }).start();
            }
        });
    }

    private void send(String data) {
        try{
            int portNum = 5001;
            Socket socket = new Socket("localhost",portNum);
            printClientLog("소켓 연결 함");
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            os.writeObject(data);
            os.flush();
            printClientLog("데이터 전송 함");

            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            printClientLog("서버로부터 받음 : " + is.readObject());
            socket.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void startServer() {
        try {
            int portNum = 5001;
            ServerSocket serverSocket = new ServerSocket(portNum);
            printServerLog("서버시작함 : " + portNum);
            while(true){
                Socket socket = serverSocket.accept();
                InetAddress clientHost = socket.getLocalAddress();
                int clientPort = socket.getPort();
                printServerLog("클라이언트 연결됨 : " + clientHost + " : " + clientPort);
                ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
                Object obj = is.readObject();
                printServerLog("데이터 받음 : " + obj);

                ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
                os.writeObject(obj+" from server.");
                os.flush();
                printServerLog("데이터 보냄");
                socket.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printClientLog(final String data) {
        Log.d("MainActivity", data);
        handler.post(new Runnable() {
            @Override
            public void run() {
                tvClient.append(data + "\n");
            }
        });
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