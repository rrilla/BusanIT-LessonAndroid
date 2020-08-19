package com.example.serviceapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public static final String TAG="MyService";

    @Override
    public void onCreate() {    //서비스 실행시 실행 메소드
        super.onCreate();
        Log.i(TAG, "onCreate() 메소드 호출");
    }

    @Override
    public void onDestroy() {   //서비스 종료시 실행 메소드
        super.onDestroy();
        Log.i(TAG, "onDestroy() 메소드 호출");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand() 메소드 호출");

        if(intent == null){
            return Service.START_STICKY;
        }else{
            processCommand(intent);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void processCommand(Intent intent){
        String command = intent.getStringExtra("command");
        String name = intent.getStringExtra("name");
        Log.d(TAG, "command : " + command +", name : " + name);

        for(int i=0; i<10; i++){
            try{
                Thread.sleep(1000);
            }catch (Exception e){}
            Log.d(TAG, "Waiting " + i + " seconds.");
        }
        Intent showIntent = new Intent(getApplicationContext(), MainActivity.class);
        showIntent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_SINGLE_TOP
                | intent.FLAG_ACTIVITY_CLEAR_TOP);
        showIntent.putExtra("command", "show");
        showIntent.putExtra("name", name+ " from service.");
        startActivity(showIntent);
    }



    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
