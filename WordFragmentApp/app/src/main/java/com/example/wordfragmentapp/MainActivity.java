package com.example.wordfragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements WordFragment.OnWordSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.word_container) != null){
            if(savedInstanceState != null){
                return;
            }
            WordFragment fragment = new WordFragment();
            fragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.word_container, fragment).commit();

        }
    }

    @Override
    public void onWordSelected(int position) {
        DefinitionFragment defFragment =
                (DefinitionFragment)(getSupportFragmentManager().findFragmentById(R.id.definition_container));
        if(defFragment != null){
            defFragment.updateDefinitionView(position);
        }else{
            DefinitionFragment newFragment = new DefinitionFragment();
            Bundle args = new Bundle();
            //args.putInt("position", position);
            args.putInt(DefinitionFragment.ARG_POSITION, position);
            newFragment.setArguments(args);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.definition_container, newFragment);
//            ft.replace(R.id.definition_container, newFragment);
//            ft.addToBackStack(null);
            ft.commit();
        }
    }
}