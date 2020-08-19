package com.example.imageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new ImageProView(this));
    }

    public static class ImageProView extends View {

        public ImageProView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Bitmap pic = BitmapFactory.
                    decodeResource(getResources(),R.drawable.lena256);
//            int picX = (this.getWidth() - pic.getWidth()) / 2;
//            int picY = (this.getHeight() - pic.getHeight()) / 2;
            int cenX = this.getWidth() /2;
            int cenY = this.getHeight() /2;

            Paint paint = new Paint();
            paint.setColor(Color.GRAY);

//            BlurMaskFilter bMask = new BlurMaskFilter(100, BlurMaskFilter.Blur.NORMAL);
//            paint.setMaskFilter(bMask);
//            canvas.drawBitmap(pic, picX, picY, paint);
//            pic.recycle();
//            canvas.drawBitmap(pic, picX, picY, paint);
            EmbossMaskFilter eMask = new EmbossMaskFilter(
                    new float[]{3,3,10}, 1,5,20);
            paint.setMaskFilter(eMask);
            //canvas.drawBitmap(pic, picX, picY, paint);
            canvas.drawCircle(cenX, cenY, 150, paint);
            pic.recycle();
        }
    }
}