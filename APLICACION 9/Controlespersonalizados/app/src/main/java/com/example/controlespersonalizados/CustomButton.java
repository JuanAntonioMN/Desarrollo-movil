package com.example.controlespersonalizados;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.graphics.Canvas;

public class CustomButton extends  androidx.appcompat.widget.AppCompatButton{

    float escala=getResources().getDisplayMetrics().density;
    Paint pFondo=new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint pFondoPress=new Paint(Paint.ANTI_ALIAS_FLAG);

    Paint pTexto=new Paint(Paint.ANTI_ALIAS_FLAG);

    public  CustomButton(Context context){
        super(context);
        inicializa();
    }

    public  CustomButton(Context context, AttributeSet attrs){
        super(context,attrs);
        inicializa();
    }

    public  CustomButton(Context context, AttributeSet attrs,int defStayleAttr){
        super(context,attrs,defStayleAttr);
        inicializa();
    }

    public  void inicializa(){
        pFondo.setColor(Color.BLACK);
        pFondo.setStyle(Paint.Style.FILL);
        pFondoPress.setColor(Color.parseColor("#FF5722"));
        pFondoPress.setStyle(Paint.Style.FILL);
        pTexto.setColor(Color.WHITE);
        pTexto.setTextSize(50f);

    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        if(this.isPressed()){
            canvas.drawRect(0,0,getWidth()*escala,getHeight()*escala,pFondoPress);

            canvas.drawText("Presionado", 10 * escala, getHeight() / 2 - ((pTexto.descent() + pTexto.ascent()) / 2),pTexto);
        }
        else {
            canvas.drawRect(0,0,getWidth()*escala,getHeight()*escala,pFondo);

        }
        canvas.drawText(getText().toString(),10*escala,getHeight()-5*escala,pTexto);

    }
}
