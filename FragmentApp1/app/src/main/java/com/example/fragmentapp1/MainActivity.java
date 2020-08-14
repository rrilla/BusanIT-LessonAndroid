package com.example.fragmentapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.container) != null) {
            if (savedInstanceState != null) {  //현재 액티비티의 상태
                return;
            }
            AFragment fragment = new AFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.container, fragment);
            ft.commit();
           //getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();
        }
    }

    public void selectFragment(View v){

    }
}