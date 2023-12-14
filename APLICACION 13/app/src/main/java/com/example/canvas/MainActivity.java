package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //creamos la instancia de nuestro canvas
        MyCanvasView myCanvasView=new MyCanvasView(getApplicationContext());
        //Lo hacemos trabajar en pantalla completa
        myCanvasView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        //Agregamos la descripcion del contenido
        myCanvasView.setContentDescription(getString(R.string.canvasContentDescription));
        //Asignamos nuestro canvas
        setContentView(myCanvasView);

    }

}