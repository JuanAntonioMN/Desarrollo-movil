package com.example.controlpersonalizado;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class SelectColor extends View {
    private int color=10;

    public SelectColor(Context context){
        super(context);
    }

    public SelectColor(Context context, AttributeSet attrs){
        super(context,attrs);
    }
    public  SelectColor(Context context,AttributeSet attrs,int defStyleAttr){
        super(context,attrs,defStyleAttr);
    }
    public  SelectColor(Context context,AttributeSet attrs,int defStyleAttr,int defStyleRes){
        super(context,attrs,defStyleAttr,defStyleRes);
    }

    @Override
    protected  void onMeasure(int widthMeasureSpec,int heigthMeasureSpec){
        int ancho=calcularAncho(widthMeasureSpec);
        int alto=calcularAlto(heigthMeasureSpec);
        setMeasuredDimension(ancho,alto);
    }

    private int calcularAlto(int heightMeasureSpec){
        int res=100;
        int modo=MeasureSpec.getMode(heightMeasureSpec);
        int limite=MeasureSpec.getSize(heightMeasureSpec);
        if(modo==MeasureSpec.AT_MOST || modo==MeasureSpec.EXACTLY){
            res=limite;
        }
        return res;
    }

    private int calcularAncho(int widthMeasureSpec){
        int res=100;
        int modo=MeasureSpec.getMode(widthMeasureSpec);
        int limite=MeasureSpec.getSize(widthMeasureSpec);
        if(modo==MeasureSpec.AT_MOST || modo==MeasureSpec.EXACTLY){
            res=limite;
        }
        return res;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float alto = getMeasuredHeight();
        int ancho = getMeasuredWidth();

        Paint pRelleno=new Paint();
        pRelleno.setStyle(Paint.Style.FILL);


        // Color rojo
        pRelleno.setColor(Color.argb(255,255,0,0));
        canvas.drawRect(0, 0, ancho/3, alto/2, pRelleno);


        // Color verde
        pRelleno.setColor(Color.argb(255,0,255,0));
        canvas.drawRect( ancho / 3, 0, (2 * ancho) / 3, alto / 2, pRelleno);

        // Color Azul
        pRelleno.setColor(Color.argb(255,0,0,255));
        canvas.drawRect( (2 * ancho) / 3, 0, ancho, alto / 2, pRelleno);

        //color seleccionado

        pRelleno.setColor(Color.argb(255,255,color,color));
        canvas.drawRect(0,alto/2f,ancho,alto,pRelleno);

        // Marco del control
        Paint pBorde= new Paint();
        pRelleno.setStyle(Paint.Style.STROKE);
        pRelleno.setColor(Color.argb(255,0,0,255));

        canvas.drawRect(0, 0f, ancho - 1, alto / 2, pRelleno);
        canvas.drawRect(0, 0f, ancho - 1, alto - 1, pRelleno);
    }

    private  OnSelectedColorListener listener=null;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getY() > 0 && event.getY() < getMeasuredHeight() / 2) {
            if (event.getX() >= 0 && event.getX() < getMeasuredWidth() / 3f) {
                // Toque en la parte izquierda (azul)
                color = Color.argb(255, 0, 0, 255);
                if (color > 0) {
                    color -= 5;
                }

            } else if (event.getX() >= getMeasuredWidth() / 3f && event.getX() < (2 * getMeasuredWidth()) / 3f) {
                // Toque en el centro (verde)
                color = Color.argb(255, 0, 255, 0);
                if (color < 255) {
                    color += 5;
                }

            } else if (event.getX() >= (2 * getMeasuredWidth()) / 3f && event.getX() < getMeasuredWidth()) {
                // Toque en la parte derecha (rojo)
                if (color < 255) {
                    color += 5;
                }

            }
            this.invalidate();

        } else if (event.getY() > getMeasuredHeight() / 2 && event.getY() < getMeasuredHeight()) {
            listener.onSelectedColor(color);
        }

        return super.onTouchEvent(event);
    }








    public void setOnColorListener(OnSelectedColorListener l){
        listener=l;
    }
}
