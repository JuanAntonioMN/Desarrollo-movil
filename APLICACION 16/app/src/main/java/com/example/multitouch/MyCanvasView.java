package com.example.multitouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;

public class MyCanvasView extends View {
    private boolean counting = false;
    private int selectedPointerIndex = -1;

    private final int SIZE=60;

    private SparseArray<PointF>punteroActivos=new SparseArray<PointF>();
    private Paint myPaint=new Paint();
    private int[]colors={
            Color.BLUE,Color.GREEN,Color.MAGENTA,
            Color.BLACK,Color.CYAN,Color.GRAY,Color.RED,Color.DKGRAY,
            Color.LTGRAY,Color.YELLOW};
    private Paint textPaint= new Paint();
    int time =0;

    public MyCanvasView(Context context){
        super(context);
        myPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        myPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(40f);
        /*
        Thread hilo= new Thread(){
            public synchronized void run(){
                while (true){
                   try{
                       Thread.sleep(1000);
                       time+=1;
                       invalidate();
                   }catch (InterruptedException e){
                   }
                }
            }
        };*/
        Thread hilo = new Thread() {
            public synchronized void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        time += 1;
                        if (time == 5) { // Cambia 5 al número deseado de segundos para el contador
                            counting = false;
                            selectRandomPointer();
                            time = 0; // Reinicia el contador
                        }
                        invalidate();
                    } catch (InterruptedException e) {
                    }
                }
            }
        };
        hilo.start();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int indice = event.getActionIndex();
        int apuntadorId = event.getPointerId(indice);

        if (event.getActionMasked() == MotionEvent.ACTION_DOWN || event.getActionMasked() == MotionEvent.ACTION_POINTER_DOWN) {
            PointF f = new PointF();
            f.x = event.getX(indice);
            f.y = event.getY(indice);
            punteroActivos.put(apuntadorId, f);

            if (!counting) {
                startCounting();
            }
        }

        // Resto del código para el movimiento y liberación de punteros

        invalidate();
        return true;
    }

    /*
    @Override
    public boolean onTouchEvent(MotionEvent event){
        int indice=event.getActionIndex();
        int apuntadorId=event.getPointerId(indice);
        if(event.getActionMasked()==MotionEvent.ACTION_DOWN ||
        event.getActionMasked()==MotionEvent.ACTION_POINTER_DOWN){
            PointF f=new PointF();
            f.x=event.getX(indice);
            f.y=event.getY(indice);
            punteroActivos.put(apuntadorId,f);
        }
        if(event.getActionMasked()==MotionEvent.ACTION_MOVE) {
            int size = event.getPointerCount();
            int i=0;
            while(i<size){
                PointF puntero=punteroActivos.valueAt(event.getPointerId(i));
                if(puntero!=null){
                    puntero.x=event.getX(i);
                    puntero.y=event.getY(i);
                }
                i++;
            }

        }
        if(event.getActionMasked()==MotionEvent.ACTION_UP ||
                event.getActionMasked()==MotionEvent.ACTION_POINTER_UP ||
                event.getActionMasked()==MotionEvent.ACTION_CANCEL){
                punteroActivos.remove(apuntadorId);
        }
        invalidate();
        return true;
    }*/
    /*
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int size=punteroActivos.size();
        int i=0;
        PointF puntero=new PointF();
        while(i<size){
            puntero=punteroActivos.valueAt(i);
            if(puntero!=null){
                myPaint.setColor(colors[i%9]);
                canvas.drawCircle(puntero.x,puntero.y,SIZE,myPaint);
            }
            i++;
        }
        canvas.drawText("Total punteros: "+punteroActivos.size(), 10f,40f,textPaint);
        canvas.drawText("Tiempo: "+time,10f,80f,textPaint);


    }*/
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int size = punteroActivos.size();
        int i = 0;
        PointF puntero = new PointF();
        while(i < size){
            puntero = punteroActivos.valueAt(i);
            if (puntero != null) {
                myPaint.setColor(colors[i % 9]);
                canvas.drawCircle(puntero.x, puntero.y, SIZE, myPaint);
            }
            i++;
        }

        if (selectedPointerIndex != -1) {
            // Resalta el puntero seleccionado
            myPaint.setColor(Color.RED); // Puedes usar otro color
            PointF selectedPuntero = punteroActivos.valueAt(selectedPointerIndex);
            if (selectedPuntero != null) {
                canvas.drawCircle(selectedPuntero.x, selectedPuntero.y, SIZE + 10, myPaint);
            }
        }

        canvas.drawText("Total punteros: " + punteroActivos.size(), 10f, 40f, textPaint);
        canvas.drawText("Tiempo: " + time, 10f, 80f, textPaint);
    }
    private void selectRandomPointer() {
        if (punteroActivos.size() > 0) {
            selectedPointerIndex = (int) (Math.random() * punteroActivos.size());
            invalidate(); // Actualiza la vista para mostrar el puntero seleccionado
        }


    }

    private void startCounting() {
        counting = true;
        time = 0;
    }


}
