package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.appcompat.content.res.AppCompatResources;

public class MyCanvasView extends View {
    Drawable[] imagenes;
    public MyCanvasView(Context context){
        super(context);
    }
    @Override
    protected void onSizeChanged(int w,int h, int oldw,int oldh){
        super.onSizeChanged(w,h,oldw,oldh);
        //setBackgroundResource(R.drawable.animacion);
        imagenes=new Drawable[5];

        // Imagen 1
        imagenes[0] = AppCompatResources.getDrawable(getContext(), R.drawable.baseline_thumb_up_alt_24);
        imagenes[0].setBounds(30, 30, 200, 200);

        // Imagen 2
        imagenes[1] = AppCompatResources.getDrawable(getContext(), R.drawable.baseline_settings_24);
        imagenes[1].setBounds(300, 300, 500, 500);

        // Imagen 3
        imagenes[2] = AppCompatResources.getDrawable(getContext(), R.drawable.baseline_rotate_left_24);
        imagenes[2].setBounds(600, 600, 800, 800);

        // Imagen 4
        imagenes[3] = AppCompatResources.getDrawable(getContext(), R.drawable.baseline_play_arrow_24);
        imagenes[3].setBounds(900, 900, 1100, 1100);

        // Imagen 5
        imagenes[4] = AppCompatResources.getDrawable(getContext(), R.drawable.baseline_keyboard_double_arrow_left_24);
        imagenes[4].setBounds(1200, 1200, 1400, 1400);
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        for (Drawable imagen : imagenes) {
            if (imagen != null) {
                imagen.draw(canvas);
            }
        }
    }
}
