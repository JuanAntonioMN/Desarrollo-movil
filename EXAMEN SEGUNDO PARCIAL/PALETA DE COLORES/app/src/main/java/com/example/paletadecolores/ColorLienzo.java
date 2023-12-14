package com.example.paletadecolores;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Rect;

public class ColorLienzo extends View {
    private int selectedColor = Color.WHITE; // Inicializa con un color predeterminado
    public ColorLienzo(Context context) {
        super(context);
    }

    public ColorLienzo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(selectedColor);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
    }


    public void setColor(int color) {
        selectedColor = color;
        invalidate(); // Vuelve a dibujar la vista con el nuevo color de fondo
    }
    public int getColor() {
        return selectedColor;
    }


}
