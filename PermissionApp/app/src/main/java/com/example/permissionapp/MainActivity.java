package com.example.permissionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] permissions = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        checkPermissions(permissions);
    }

    private void checkPermissions(String[] permissions) {
        ArrayList<String> targetList = new ArrayList<String>();
        for(int i=0; i<permissions.length; i++){
            String currPermission = permissions[i];
            int permissionCheck = ContextCompat.
                    checkSelfPermission(this, currPermission);
            if(permissionCheck == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, currPermission+"권한 있음",
                        Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, currPermission+"권한 없음",
                        Toast.LENGTH_LONG).show();
                if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                        currPermission)){
                    Toast.makeText(this, currPermission+"권한설정이 필요함",
                            Toast.LENGTH_LONG).show();
                }else{
                    targetList.add(currPermission);
                }
            }
        }
        String[] targets = new String[targetList.size()];
        targetList.toArray(targets);
        ActivityCompat.requestPermissions(this, targets, 101);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case 101:{
                if(grantResults.length > 0 &&
                grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "첫번쨰 권한을 사용자가 승인함",
                            Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "첫번째 권한 거부함",
                            Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }
}