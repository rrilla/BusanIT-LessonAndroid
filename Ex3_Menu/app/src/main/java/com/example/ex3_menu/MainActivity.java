package com.example.ex3_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView img1, img2, img3;
    TextView tv;
    int rotate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.imageView1);
        img2 = findViewById(R.id.imageView2);
        img3 = findViewById(R.id.imageView3);
        tv = findViewById(R.id.textView);
        //rotate = Integer.parseInt(tv.getText().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menutest, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            /*case R.id.itemRotate:
                rotate += 30;
                if(rotate >=360) rotate = 0;
                img1.setRotation(rotate);
                break;*/
            case R.id.item1:
                img1.setVisibility(View.VISIBLE);
                img2.setVisibility(View.GONE);
                img3.setVisibility(View.GONE);
                break;
            case R.id.item2:
                img2.setVisibility(View.VISIBLE);
                img1.setVisibility(View.GONE);
                img3.setVisibility(View.GONE);
                break;
            case R.id.item3:
                img3.setVisibility(View.VISIBLE);
                img2.setVisibility(View.GONE);
                img1.setVisibility(View.GONE);
                break;
//            case R.id.item2:
//                scale*=2;
//                if(scale > 10)scale = 10;
//                button.setScaleX(scale);
//                button.setScaleY(scale);
//                break;
//            case R.id.item3:
//                scale/=2;
//                if (scale < 1) scale = 1;
//                button.setScaleX(scale);
//                button.setScaleY(scale);
        }
        return true;
    }
}