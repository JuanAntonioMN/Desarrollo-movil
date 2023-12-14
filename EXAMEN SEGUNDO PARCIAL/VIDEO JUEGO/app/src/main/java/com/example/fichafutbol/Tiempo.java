package com.example.fichafutbol;

import android.os.Handler;

public class Tiempo {
    private int contador;
    private Handler handler;
    private Runnable runnable;

    Tiempo() {
        contador = 0;
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                updateTimer();
            }
        };
    }

    public void startTimer() {
        handler.post(runnable);
    }

    public void stopTimer() {
        handler.removeCallbacks(runnable);
    }

    public int getContador() {
        return contador;
    }



    private void updateTimer() {
        contador++;
        handler.postDelayed(runnable, 1000);
    }
}
