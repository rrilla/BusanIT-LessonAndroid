package com.example.menuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    Button button;
    int rotate;
    int scale = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메뉴사용");
        linearLayout = findViewById(R.id.linerLayout1);
        button = findViewById(R.id.button);
        registerForContextMenu(button);     //메뉴를 사용할 위젯 등록
        registerForContextMenu(linearLayout);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        if(v==button){
            menu.setHeaderTitle("배경색");
            inflater.inflate(R.menu.menu3, menu);
        }
        if(v==linearLayout){
            menu.setHeaderTitle("버튼설정");
            inflater.inflate(R.menu.menu2, menu);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        /*menu.add(0, 1, 0, "배경색(빨강)"); //java코드만을 이용한 메뉴
        menu.add(0, 2, 0, "배경색(초록)");
        menu.add(0, 3, 0, "배경색(파랑)");*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemRed:  //1
                linearLayout.setBackgroundColor(Color.RED);
                break;
            case R.id.itemGreen:    //2
                linearLayout.setBackgroundColor(Color.GREEN);
                break;
            case R.id.itemBlue:     //3
                linearLayout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.subRotate:
                rotate += 10;
                if(rotate >=360) rotate = 0;
                button.setRotation(rotate);
                break;
            case R.id.subSize:
                scale*=2;
                if(scale > 10)scale = 10;
                button.setScaleX(scale);
                button.setScaleY(scale);
                break;
            case R.id.minSize:
                scale/=2;
                if (scale < 1) scale = 1;
                button.setScaleX(scale);
                button.setScaleY(scale);
        }
        return true;
    }
}