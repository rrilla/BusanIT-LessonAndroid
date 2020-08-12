package com.example.ex4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    ImageView iv;
    Button btn;
    View dlgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg=findViewById(R.id.rg);
        btn=findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title="";
                int drawable=0;
                int id=rg.getCheckedRadioButtonId();
                switch (id){
                    case R.id.rbDog:
                        title="강아지";
                        drawable=R.drawable.dog;
                        break;
                    case R.id.rbCat:
                        title="고양이";
                        drawable=R.drawable.cat;
                        break;
                    case R.id.rbRabbit:
                        title="토끼";
                        drawable=R.drawable.rabbit;
                        break;
                    case R.id.rbHorse:
                        title="말";
                        drawable=R.drawable.dog2;
                        break;

                }

                dlgView=View.inflate(MainActivity.this,R.layout.dialog,null);
                AlertDialog.Builder dlg=new AlertDialog.Builder(MainActivity.this);
                iv=dlgView.findViewById(R.id.imageView);
                iv.setImageResource(drawable);
                dlg.setTitle(title);
                dlg.setView(dlgView);
                dlg.setPositiveButton("닫기",null);
                dlg.show();

            }
        });

    }
}