package com.example.cardviewapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Layout1 extends LinearLayout {
    ImageView imageView;
    TextView tvName, tvPhone;

    public Layout1(Context context) {
        super(context);
        init(context);
    }

    public Layout1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {  //인플레터 시키는 메서드
        LayoutInflater inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout1, this, true);
        imageView = findViewById(R.id.iv);
        tvName = findViewById(R.id.tvName);
        tvPhone = findViewById(R.id.tvPhone);
    }

    public void setImage(int resId){
        imageView.setImageResource(resId);
    }

    public void setName(String name){
        tvName.setText(name);
    }

    public void setMobile(String mobile){
        tvPhone.setText(mobile);
    }
}
