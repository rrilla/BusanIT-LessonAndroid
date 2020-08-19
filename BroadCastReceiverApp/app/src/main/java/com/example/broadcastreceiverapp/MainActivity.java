package com.example.broadcastreceiverapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.pedro.library.AutoPermissionsListener;

public class MainActivity extends AppCompatActivity
        implements AutoPermissionsListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onDenied(int i, String[] strings) {

    }

    @Override
    public void onGranted(int i, String[] strings) {

    }
}