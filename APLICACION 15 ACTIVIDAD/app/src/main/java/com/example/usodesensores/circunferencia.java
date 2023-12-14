package com.example.usodesensores;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class circunferencia extends View {
    private Paint paint;
    private float centerX;
    private float centerY;
    private float currentX = 0;
    private float currentY = 0;
    private  int radius=50;
    public circunferencia(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GRAY);
        centerX = Math.max(radius, Math.min(getWidth() - radius, centerX));
        centerY = Math.max(radius, Math.min(getHeight() - radius, centerY));

        canvas.drawCircle(centerX, centerY,radius, paint);
        paint.setTextSize(50);
        String text = "X: " + centerX + ", Y: " +centerY;
        canvas.drawText(text, 50, 60, paint);
    }
    public void moveCircle(float displacementX, float displacementY, float force) {

        currentX = displacementX * force;
        currentY = displacementY * force;

        centerX += currentX;
        centerY += currentY;
        invalidate();
    }


}
