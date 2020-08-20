package com.example.animationapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout page;
    Button btn;
    boolean isPageOpen=false;
    Animation translateLeft,translateRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        page=findViewById(R.id.page);
        btn=findViewById(R.id.button);
        translateLeft= AnimationUtils.loadAnimation(this,R.anim.left_translate);
        translateRight=AnimationUtils.loadAnimation(this,R.anim.right_translate);

        PageAnimationListener listener=new PageAnimationListener();
        translateRight.setAnimationListener(listener);
        translateLeft.setAnimationListener(listener);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPageOpen){
                    page.startAnimation(translateRight);
                }else{
                    page.setVisibility(View.VISIBLE);
                    page.startAnimation(translateLeft);

                }
            }
        });
    }
    private class PageAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if(isPageOpen){
                page.setVisibility(View.INVISIBLE);
                btn.setText("Open");
                isPageOpen=false;
            }else{
                btn.setText("Close");
                isPageOpen=true;
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}