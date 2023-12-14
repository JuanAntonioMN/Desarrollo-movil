package com.example.controlespersonalizadoscombinandovarioscontroles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FechaControl fechaC=findViewById(R.id.crtlFecha);
        //fechaC.SetFecha(1,1,2023);

        fechaC.SetOnDateChangeListener(new OnDateChangeListener() {
            @Override
            public void onDateChange(String dia, String mes, String anio) {
                Toast.makeText(getApplicationContext(),"Fecha: "+dia+" / "+mes+" / "+anio, Toast.LENGTH_SHORT).show();
            }
        });
    }
}