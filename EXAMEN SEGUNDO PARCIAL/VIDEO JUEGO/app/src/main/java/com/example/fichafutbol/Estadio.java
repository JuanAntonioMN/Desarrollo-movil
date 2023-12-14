package com.example.fichafutbol;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.View;

public class Estadio extends View {
    //Balon pelota = new Balon();
    float posx;
    float posy;
   private int x;
    // Declarar y asignar un valor a factorDeVelocidad
    private float factorDeVelocidad = 1.0f; // Puedes ajustar este valor según tus necesidades

    private int y;
    int [][] canchaDeFutbol = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
            {1,2,3,2,3,3,3,2,2,2,3,2,2,3,3,3,2,3,2,1},
            {1,2,3,2,2,2,2,2,3,2,2,3,2,2,2,2,2,3,2,1},
            {1,3,2,2,3,2,2,2,2,3,2,2,2,2,2,3,2,2,3,1},
            {1,2,2,2,2,3,2,2,3,2,2,3,2,2,3,2,2,2,2,1},
            {1,1,1,1,2,2,3,2,2,2,3,2,2,3,2,2,1,1,1,1},
            {1,2,2,1,2,2,2,2,3,2,2,3,2,2,2,2,1,2,2,1},
            {1,1,2,2,2,3,2,2,2,3,2,2,2,2,3,2,2,2,1,1},
            {1,2,2,2,2,2,2,2,3,2,2,3,2,2,2,2,2,2,2,1},
            {1,1,2,2,2,3,2,2,2,2,3,2,2,2,3,2,2,2,1,1},
            {1,2,2,1,2,2,2,2,3,2,2,3,2,2,2,2,1,2,2,1},
            {1,1,1,1,2,2,3,2,2,3,2,2,2,3,2,2,1,1,1,1},
            {1,2,2,2,2,3,2,2,3,2,2,3,2,2,3,2,2,2,2,1},
            {1,2,2,2,3,2,2,2,2,2,3,2,2,2,2,3,2,2,2,1},
            {1,3,2,2,2,2,2,2,3,2,2,3,2,2,2,2,2,2,3,1},
            {1,2,3,2,3,3,3,2,2,3,2,3,2,3,3,3,2,3,2,1},
            {1,2,3,2,2,2,2,2,3,2,2,2,2,2,2,2,2,3,2,1},
            {1,2,2,2,3,2,2,2,2,2,2,2,2,2,2,3,2,2,2,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

    public Estadio(Context context) {
        super(context);
    }

    public Estadio(Context context, AttributeSet attrs){
     super(context,attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Configura el pincel para dibujar la cancha
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        int cellSize = 70;  // Tamaño de la celda

        // Calcula la nueva posición de la pelota en función de los datos del acelerómetro
        int nuevaX = (int) (posx + (factorDeVelocidad * getX()));  // factorDeVelocidad es una constante que puedes ajustar
        int nuevaY = (int) (posy + (factorDeVelocidad * getY()));

        // Asegúrate de que la nueva posición esté dentro de los límites del lienzo
        nuevaX = Math.max(0, Math.min(nuevaX, getWidth() - cellSize));
        nuevaY = Math.max(0, Math.min(nuevaY, getHeight() - cellSize));

        // Actualiza la posición de la pelota en el objeto Balon


        // Dibuja la cancha (como lo hacías anteriormente)
        for (int i = 0; i < canchaDeFutbol.length; i++) {
            for (int j = 0; j < canchaDeFutbol[i].length; j++) {
                int value = canchaDeFutbol[i][j];
                if (value == 1) {
                    paint.setColor(Color.BLACK);
                } else if (value == 2) {
                    paint.setColor(Color.GREEN);
                } else if (value == 3) {
                    paint.setColor(Color.TRANSPARENT);
                }
                // Dibuja un rectángulo en el lienzo para representar cada celda
                canvas.drawRect(j * cellSize, i * cellSize, (j + 1) * cellSize, (i + 1) * cellSize, paint);
            }
        }

       
    }



    public float getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }


    public float getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
