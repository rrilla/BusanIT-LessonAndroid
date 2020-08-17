package com.example.exfragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements NameFragment.OnNameSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.name_container) != null){
            if(savedInstanceState != null){
                return;
            }
            NameFragment fragment = new NameFragment();
            fragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.name_container, fragment).commit();
        }
    }

    @Override
    public void onNameSelected(int position) {
        ImgFragment defFragment =
                (ImgFragment)(getSupportFragmentManager().findFragmentById(R.id.img_container));
        if(defFragment != null){
            defFragment.updateDefinitionView(position);
        }else{
            ImgFragment newFragment = new ImgFragment();
            Bundle args = new Bundle();
            //args.putInt("position", position);
            args.putInt(ImgFragment.ARG_POSITION, position);
            newFragment.setArguments(args);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.img_container, newFragment);
//            ft.replace(R.id.definition_container, newFragment);
//            ft.addToBackStack(null);
            ft.commit();
        }
    }
}