package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(new MyCanvasView(getApplicationContext()));
       /* AnimationDrawable animacion=(AnimationDrawable)
                AppCompatResources.getDrawable(getApplicationContext(),
                        R.drawable.animacion);
        ImageView vista=new ImageView(getApplicationContext());
        vista.setBackgroundColor(Color.WHITE);
        vista.setImageDrawable(animacion);
        animacion.start();
        setContentView(vista);
        */
    }
}