package com.example.fichafutbol;

import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Futbolito extends AppCompatActivity {
    Estadio estadio;
    Canvas canvas;
    Tiempo tiempo=new Tiempo();
    Handler handler = new Handler();
    TextView contador;
    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private Sensor gyroscopeSensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videojuego);
        estadio = findViewById(R.id.Cancha);
        contador=findViewById(R.id.contador);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        if (accelerometerSensor != null) {
            sensorManager.registerListener(sensorEventListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (gyroscopeSensor != null) {
            sensorManager.registerListener(sensorEventListener, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

        // Inicia el temporizador
        tiempo.startTimer();
        // Actualiza el contador en tu TextView
        actualizarContador();
    }
    private SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                float x = event.values[0]; // Valor de aceleración en el eje X
                float y = event.values[1]; // Valor de aceleración en el eje Y

                // Establece las nuevas coordenadas en el objeto estadio
                estadio.setX(x);
                estadio.setY(y);

            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    };

    private void actualizarContador() {
        contador.setText("Tiempo: " + tiempo.getContador());


            // Programa una actualización periódica del contador
            contador.postDelayed(new Runnable() {
                @Override
                public void run() {
                    actualizarContador();
                }
            }, 1000); // Actualiza cada 1 segundo (1000 milisegundos)
    }
}
