package com.example.controlespersonalizados;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.annotation.NonNull;

import org.jetbrains.annotations.Nullable;

import java.text.AttributedCharacterIterator;

public class CustomEditText extends androidx.appcompat.widget.AppCompatEditText {

    float escala=getResources().getDisplayMetrics().density;
    Paint pFondo= new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint pTexto= new Paint(Paint.ANTI_ALIAS_FLAG);

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawRect(getWidth()-300*escala,5*escala,getWidth()-5*escala,25*escala,pFondo);
        canvas.drawText(""+getText().toString().length(),getWidth()-28*escala,17*escala,pTexto);
    }

    public CustomEditText(@NonNull Context context){
        super(context);
        inicializa();
    }

    public CustomEditText(@NonNull Context context, @Nullable AttributeSet attrs){
        super(context,attrs);
        inicializa();
    }

    public CustomEditText(@NonNull Context context, @Nullable AttributeSet attrs,int defStayleAttr){
        super(context,attrs,defStayleAttr);
        inicializa();
    }

    public  void inicializa(){
        pFondo.setColor(Color.BLACK);
        pFondo.setStyle(Paint.Style.FILL);
        pTexto.setColor(Color.WHITE);
        pTexto.setTextSize(30f);
    }



}
