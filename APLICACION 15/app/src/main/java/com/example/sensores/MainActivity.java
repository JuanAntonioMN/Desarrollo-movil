package com.example.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private LinearLayout linearLayout;
    private TextView textView[][]=new TextView[20][3];
    private SensorManager sensorManager;
    private List<Sensor>listenerSensors;
    private  Sensor sensors[]=new Sensor[20];
    private TextView textView1;
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       try {
            linearLayout=(LinearLayout) findViewById(R.id.linearLayout);
            sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
            listenerSensors=sensorManager.getSensorList(Sensor.TYPE_ALL);
            int n=0;
            textView1=findViewById(R.id.textView);
            textView1.setText("Sensores: "+listenerSensors.size());
            for (Sensor sensor:listenerSensors){
                sensors[n]=sensor;
                TextView inTextView=new TextView(this);
                inTextView.setText(sensor.getName());
                linearLayout.addView(inTextView);
                LinearLayout inLinerarLayout=new LinearLayout(this);
                linearLayout.addView(inLinerarLayout);
                for (int i=0;i<3;i++){
                    textView[n][i]=new TextView(this);
                    textView[n][i].setText("?");
                    textView[n][i].setWidth(300);
                }
                TextView xTextView=new TextView(this);
                xTextView.setText(" x: ");
                inLinerarLayout.addView(xTextView);
                inLinerarLayout.addView(textView[n][0]);

                TextView yTextView=new TextView(this);
                yTextView.setText(" Y: ");
                inLinerarLayout.addView(yTextView);
                inLinerarLayout.addView(textView[n][1]);

                TextView zTextView=new TextView(this);
                zTextView.setText(" Z: ");
                inLinerarLayout.addView(zTextView);
                inLinerarLayout.addView(textView[n][2]);

                sensorManager.registerListener(this,sensor,sensorManager.SENSOR_DELAY_UI);
                n++;
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext()," Error" +e.toString(),Toast.LENGTH_SHORT);
        }
    }

    public void onSensorChanged(SensorEvent event){
        try{
            synchronized (this){
                int n=0;
                for (Sensor sensor: listenerSensors){
                    if (event.sensor==sensor){
                        for (int i=0;i<event.values.length;i++){
                            textView[n][i].setText(Math.round(event.values[i]*100d)/100d+"");
                        }
                    }
                    n++;
                }
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Error "+ e.toString(),Toast.LENGTH_SHORT);
        }
    }
    public  void onAccuracyChanged(Sensor sensor,int accuacy){

    }
}

