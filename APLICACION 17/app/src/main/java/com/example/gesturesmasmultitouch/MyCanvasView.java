package com.example.gesturesmasmultitouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.view.GestureDetectorCompat;

import java.util.HashMap;
import java.util.Iterator;

public class MyCanvasView extends View implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    private final int SIZE=60;
    //Matriz de punteros a objetos PonitF
    private HashMap<Integer,PointF> punterosActivos= new HashMap<Integer,PointF>();
    private Paint myPaint=new Paint();

    private int[]colors={
            Color.BLUE,Color.GREEN,Color.MAGENTA,
            Color.BLACK,Color.CYAN,Color.GRAY,Color.RED,Color.DKGRAY,
            Color.LTGRAY,Color.YELLOW
    };
    private Paint textPaint=new Paint();
    //Gesture
    private String txtGesture;

    private String otro;
    private GestureDetectorCompat mDetector;

    public MyCanvasView(Context context){
        super(context);
        myPaint= new Paint(Paint.ANTI_ALIAS_FLAG);
        myPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(40f);
        txtGesture="gesture actual";
        mDetector= new GestureDetectorCompat(context.getApplicationContext(),this);
        mDetector.setOnDoubleTapListener(this);

    }

    public boolean onTouchEvent(MotionEvent event){
        int indice=event.getActionIndex();
        int apuntadorID=event.getPointerId(indice);
        if(event.getActionMasked()==MotionEvent.ACTION_DOWN || event.getActionMasked()==MotionEvent.ACTION_POINTER_DOWN){
            PointF f=new PointF();
            f.x=event.getX(indice);
            f.y=event.getY(indice);
            punterosActivos.put(apuntadorID,f);
        }
        if (event.getActionMasked()==MotionEvent.ACTION_MOVE){
            int size=event.getPointerCount();
            int i=0;
            while (i<size){
                PointF puntero=punterosActivos.get(event.getPointerId(i));
                if(puntero!=null){
                    puntero.x=event.getX(i);
                    puntero.y=event.getY(i);
                }
                i++;
            }
        }
        if (event.getActionMasked()==MotionEvent.ACTION_UP ||
                event.getActionMasked()==MotionEvent.ACTION_POINTER_UP ||
                event.getActionMasked()==MotionEvent.ACTION_CANCEL){
            punterosActivos.remove(apuntadorID);
            PointF f=new PointF();
            f.x=event.getX(indice);
            f.y=event.getY(indice);
        }
        invalidate();
        if (mDetector.onTouchEvent(event)){
            return true;
        }
        else{
            return super.onTouchEvent(event);
        }
    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int size=punterosActivos.size();
        int i=0;
        PointF puntero=new PointF();
        Iterator<Integer>itr=punterosActivos.keySet().iterator();
        while (itr.hasNext()){
            i=itr.next();
            puntero=punterosActivos.get(i);
            if(puntero!=null){
                myPaint.setColor(colors[i%9]);
            }
            canvas.drawCircle(puntero.x,puntero.y,SIZE,myPaint);
        }
        canvas.drawText("Total punteros: "+punterosActivos.size(),10f,40f,textPaint);
        canvas.drawText("Gesture: ",10f,80f,textPaint);
        canvas.drawText(txtGesture,10f,120f,textPaint);

    }

    @Override
    public  boolean onSingleTapConfirmed(MotionEvent motionEvent){
        otro="onDoubleTap";
        otro+=motionEvent.toString();
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent){
        txtGesture="onDoubleTap";
        txtGesture+=motionEvent.toString();
        return true;
    }
    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent){
        txtGesture="onDoubleTapEvent";
        txtGesture+=motionEvent.toString();
        return true;
    }
    @Override
    public boolean onDown(MotionEvent motionEvent){
        txtGesture="onDown";
        txtGesture+=motionEvent.toString();
        return true;
    }
    @Override
    public void onShowPress(MotionEvent motionEvent){
        txtGesture="onDoubleTap";
        txtGesture+=motionEvent.toString();

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent){
        txtGesture="onSingleTapUp";
        txtGesture+=motionEvent.toString();
        return true;
    }
    @Override
    public boolean onScroll(MotionEvent motionEvent,MotionEvent motionEvent1,float v,float v1){
        txtGesture="onScroll";
        txtGesture+=motionEvent.toString();
        return true;
    }
    @Override
    public void onLongPress(MotionEvent motionEvent){
        txtGesture="onLongPress";
        txtGesture+=motionEvent.toString();
        invalidate();
    }
    @Override
    public boolean onFling(MotionEvent motionEvent,MotionEvent motionEvent1,float v,float v1){
        txtGesture="onFling";
        txtGesture+=motionEvent.toString();
        return true;
    }
}