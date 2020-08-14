package com.example.intentapp4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {    //액티비티 생성시 실행 메서드
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton(View view){
        Uri uri = null;
        Intent intent = null;
        switch (view.getId()){
            case R.id.btnDial:
                uri = Uri.parse("tel : 010-3234-5235");
                intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
                break;
            case R.id.btnWeb:
                uri = Uri.parse("http://m.naver.com");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.btnGoogle:
                uri = Uri.parse("http://maps.google.com/maps?q="+35.3017313+","+128.4024513);
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.btnSearch:
                intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "점심추천");
                startActivity(intent);
                break;
            case R.id.btnSms:
                intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "안녕하세용");
                intent.setData(Uri.parse("smsto : " + Uri.encode("010-6422-2642")));
                startActivity(intent);
                break;
            case R.id.btnPhoto:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
                break;
        }
    }
}