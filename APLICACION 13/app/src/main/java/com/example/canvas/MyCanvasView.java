package com.example.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Toast;

import androidx.core.content.res.ResourcesCompat;

public class MyCanvasView extends View {
    private float motionTouchEventX=0f;
    private float motionTouchEventY=0f;
    private RectF clickableArea;

    private float currentX=0f;
    private float currentY=0f;
    Canvas extraCanvas=null;
    Bitmap extraBitmap=null;
    private final float STROKE_WIDTH=12f;
    int backgroundColor= ResourcesCompat.getColor(getResources(),R.color.colorBackground,null);

    int drawColor=ResourcesCompat.getColor(getResources(),R.color.colorPaint,null);

    int touchTolerance= ViewConfiguration.get(getContext()).getScaledTouchSlop();
    //Objeto path, que guardara lo que dibujamos
    Path path=new Path();
    Paint paint=new Paint();
    Paint paintText=new Paint();
    Paint paintText2=new Paint();
    Paint paintText3=new Paint();
    Paint paintText4=new Paint();
    Paint paintText5=new Paint();
    Paint paintText6=new Paint();
    public MyCanvasView(Context context){
        super(context);
        //Inicializamos el objeto paint
        paint.setColor(drawColor);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(STROKE_WIDTH);

        paintText.setColor(Color.argb(255,100,100,100));
        paintText.setTextSize(50f);

        paintText2.setColor(Color.argb(255,100,100,100));
        paintText2.setTextSize(50f);

        paintText3.setColor(Color.argb(255,100,100,100));
        paintText3.setTextSize(50f);

        paintText4.setColor(Color.argb(255,100,100,100));
        paintText4.setTextSize(50f);

        paintText5.setColor(Color.argb(255,100,100,100));
        paintText5.setTextSize(50f);

        paintText6.setColor(Color.argb(255,100,100,100));
        paintText6.setTextSize(50f);
    }
    public void touchStart(){

        path.reset();
        path.moveTo(motionTouchEventX,motionTouchEventY);
        currentX=motionTouchEventX;
        currentY=motionTouchEventY;
    }
    public void touchMove(){
        float dx=Math.abs(motionTouchEventX-currentX);
        float dy=Math.abs(motionTouchEventY-currentY);
        if(dx>=touchTolerance || dy>=touchTolerance){
            path.quadTo(currentX,currentY,
                    (motionTouchEventX+currentX)/2,
                    (motionTouchEventY+currentY)/2);
            currentX=motionTouchEventX;
            currentY=motionTouchEventY;
            extraCanvas.drawPath(path,paint);
        }
        invalidate();

    }
    public  void touchUp(){
        path.reset();
    }

    private void  reset(){
        if(extraBitmap!=null){
            extraBitmap.recycle();
        }

        extraBitmap=Bitmap.createBitmap(this.getMeasuredWidth(),this.getHeight(),Bitmap.Config.ARGB_8888);
        extraCanvas=new Canvas(extraBitmap);
        extraCanvas.drawColor(backgroundColor);
        Toast.makeText(this.getContext(), "Borrando", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSizeChanged(int w,int h, int oldw,int oldh){
        super.onSizeChanged(w,h,oldw,oldh);

        reset();
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawBitmap(extraBitmap,0f,0f,null);
        canvas.drawRect(0,0,1200,80,paint);
        canvas.drawText("reset",20,60,paintText);
        canvas.drawText("Circle",200,60,paintText2);
        canvas.drawText("Rect",400,60,paintText3);
        canvas.drawText("Oval",600,60,paintText4);
        canvas.drawText("Arc",800,60,paintText5);
        canvas.drawText("Puntos",1000,60,paintText5);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        motionTouchEventX=event.getX();
        motionTouchEventY=event.getY();

            if (motionTouchEventX < 200 && motionTouchEventY < 200) {
                reset();
            }
            if (motionTouchEventX >= 200 && motionTouchEventY < 400) {
                // Dibujar un círculo
                drawCircle(motionTouchEventX, motionTouchEventY, 50f);
            }
            if (motionTouchEventX >= 400 && motionTouchEventY < 600) {
                // Dibujar un rectángulo
                drawRect(motionTouchEventX, motionTouchEventY, motionTouchEventX + 100, motionTouchEventY + 50);
            }
            if (motionTouchEventX >= 600 && motionTouchEventY < 800) {
                // Dibujar un óvalo
                drawOval(motionTouchEventX, motionTouchEventY, 100, 50);
            }
            if (motionTouchEventX >= 800 && motionTouchEventY<1000) {
                // Dibujar un arco
                drawArc(motionTouchEventX - 50, motionTouchEventY - 50, motionTouchEventX + 50, motionTouchEventY + 50, 0, 90);
            }
            if (motionTouchEventX>=1000 && motionTouchEventY<1200) {
                //Dibujar puntos
                drawPoint(motionTouchEventX, motionTouchEventY);
            }


        if(event.getAction()==MotionEvent.ACTION_DOWN){
            touchStart();
        }
        if(event.getAction()==MotionEvent.ACTION_MOVE){
            touchMove();
        }
        if(event.getAction()==MotionEvent.ACTION_UP){
            touchUp();
        }
        //return super.onTouchEvent(event);

        return true;
    }

    public void drawCircle(float x, float y, float radius) {
        extraCanvas.drawCircle(x, y, radius, paint);
        invalidate();
    }

    public void drawOval(float left, float top, float right, float bottom) {
        RectF rect = new RectF(left, top, right, bottom);
        extraCanvas.drawOval(rect, paint);
        invalidate();
    }
    public void drawRect(float left, float top, float right, float bottom) {
        extraCanvas.drawRect(left, top, right, bottom, paint);
        invalidate();
    }

    public void drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle) {
        RectF rect = new RectF(left, top, right, bottom);
        extraCanvas.drawArc(rect, startAngle, sweepAngle, true, paint);
        invalidate();
    }
    
    public void drawPoint(float x, float y) {
        extraCanvas.drawCircle(x, y, 1f, paint);
        invalidate();
    }


}
